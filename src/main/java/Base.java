import appiumAutomate.drivers.AndroidDriverProvider;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Base {

//    @AfterTest
//    public void afterTest(){
//        clearDB();
//    }


    public void testWait() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void configAppium() throws InterruptedException {
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverProvider.class.getName();
        open();
        AqaStart aqa = new AqaStart();
        aqa.clickAQAServerStartStopButton();
    }
}
