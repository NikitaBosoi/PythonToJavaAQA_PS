import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class AqaServerButton extends Base{
    AppiumDriver driver;


    public SelenideElement stopStartAqaButton(){
        return $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.widget.Button[24]");
    }

    @Test
    public void printBtnName(){
        System.out.println(stopStartAqaButton().getText().contains("STOP"));
    }

    @Test
    public void clickAQAServerStartStopButton() throws InterruptedException {
        if(stopStartAqaButton().getText().contains("STOP")){
            stopStartAqaButton().click();
            Thread.sleep(500);
            stopStartAqaButton().click();
        } else if (stopStartAqaButton().getText().contains("START")) {
            stopStartAqaButton().click();
        } else {
            System.out.println("Непонятное состояние кнопки. Обрати внимание!");
        }
    }

    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
