package com.demoqa.base;

import org.testng.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestResultListener implements ITestListener {
    private final List<Map<String, String>> testCases = new ArrayList<>();
    private static final String JSON_FILE_PATH = "target/test-results.json";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final long startTime = System.currentTimeMillis();

    @Override
    public void onTestSuccess(ITestResult result) {
        saveTestResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveTestResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveTestResult(result, "SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        saveResultsToJson();
    }

    private void saveTestResult(ITestResult result, String status) {
        Map<String, String> testResult = new HashMap<>();
        String className = result.getTestClass().getName();

        // Extract Test Name (excluding last word "Test")
        String testName = className.substring(className.lastIndexOf('.') + 1).replaceAll("Test$", "");

        // Extract Test Case ID and Description from @Test annotation
        String testCaseId = "";
        String description = "";

        if (result.getMethod().getDescription() != null) {
            description = result.getMethod().getDescription();
            testCaseId = description.split(":")[0].trim(); // Assuming "TC005: Some description"
        }

        // Capture start & end time
        Date startDate = new Date(result.getStartMillis());
        Date endDate = new Date(result.getEndMillis());
        long timeTakenMs = result.getEndMillis() - result.getStartMillis();

        testResult.put("Status", status);
        testResult.put("Test Name", testName);
        testResult.put("Test Case ID", testCaseId);
        testResult.put("Time (ms)", String.valueOf(timeTakenMs));
        testResult.put("Time Span", formatTimeSpan(timeTakenMs));
        testResult.put("Start Time", DATE_FORMAT.format(startDate));
        testResult.put("End Time", DATE_FORMAT.format(endDate));
        testResult.put("Class", className);
        testResult.put("Description", description);

        testCases.add(testResult);
    }

    private void saveResultsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Map<String, Object>> existingRuns = new ArrayList<>();

        // Read existing runs if file exists
        File file = new File(JSON_FILE_PATH);
        if (file.exists()) {
            try (Reader reader = new FileReader(JSON_FILE_PATH)) {
                Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
                existingRuns = gson.fromJson(reader, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Store a single test run
        long endTime = System.currentTimeMillis();
        Map<String, Object> testRun = new HashMap<>();
        testRun.put("Run ID", UUID.randomUUID().toString()); // Unique run ID
        testRun.put("Execution Date", DATE_FORMAT.format(new Date(startTime)));
        testRun.put("Total Time", formatTimeSpan(endTime - startTime));
        testRun.put("Total Test Cases", testCases.size());
        testRun.put("Test Cases", testCases);

        existingRuns.add(testRun);

        // Write back to JSON
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            gson.toJson(existingRuns, writer);
            System.out.println("Test run results saved to " + JSON_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Format timespan as HH:mm:ss.SSS
    private String formatTimeSpan(long millis) {
        long hours = millis / 3600000;
        long minutes = (millis % 3600000) / 60000;
        long seconds = (millis % 60000) / 1000;
        long ms = millis % 1000;
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, ms);
    }
}
