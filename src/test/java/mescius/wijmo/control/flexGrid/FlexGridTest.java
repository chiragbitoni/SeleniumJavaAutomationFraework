package mescius.wijmo.control.flexGrid;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mescius.wijmo.base.BaseTest;

public class FlexGridTest extends BaseTest {
    @BeforeClass
    public void setControlCategory() {
        controlCategory = "FlexGrid/";
    }

    @Test
    public void TC_GL7047(){
        fileName = "TC_GL7047.html";
        loadUrl();
    }
}
