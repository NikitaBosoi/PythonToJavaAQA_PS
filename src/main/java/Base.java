import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class Base {

    public void clearDB(){
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("adb root");
            Thread.sleep(1500);
            rt.exec("adb shell rm data/data/com.katemedia.core.debug/databases/datastorage-exposed.db");
            Thread.sleep(1500);
            rt.exec("adb shell am start -a com.example.ACTION_NAME -n com.katemedia.core.debug/com.katemedia.core.PaymentServiceTestActivity").waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void afterTest(){
        clearDB();
    }


    public void testWait() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void wait500(){
        wait500();
    }
}
