package com.demoqa.base;

import org.testng.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestResultListener implements ITestListener {
    private final List<Map<String, String>> testResults = new ArrayList<>();

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
        String methodName = result.getMethod().getMethodName();

        // Extract Test Name (excluding last word "Test")
        String testName = className.substring(className.lastIndexOf('.') + 1);
        testName = testName.replaceAll("Test$", "");

        // Extract Test Case ID and Description from @Test annotation
        String testCaseId = "";
        String description = "";

        if (result.getMethod().getDescription() != null) {
            description = result.getMethod().getDescription();
            testCaseId = description.split(":")[0].trim(); // Assuming "TC005: Some description"
        }

        testResult.put("Status", status);
        testResult.put("Test Name", testName);
        testResult.put("Test Case ID", testCaseId);
        testResult.put("Time (ms)", String.valueOf(result.getEndMillis() - result.getStartMillis()));
        testResult.put("Class", className);
        testResult.put("Description", description);

        testResults.add(testResult);
    }

    private void saveResultsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("target/test-results.json")) {
            gson.toJson(testResults, writer);
            System.out.println("Test results saved to target/test-results.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
