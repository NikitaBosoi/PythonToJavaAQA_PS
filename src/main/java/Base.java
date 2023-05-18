import appiumAutomate.drivers.AndroidDriverProvider;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

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
        AqaServerButton aqa = new AqaServerButton();
        aqa.clickAQAServerStartStopButton();
    }
}
