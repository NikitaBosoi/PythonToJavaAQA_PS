import org.junit.Test;

import java.io.IOException;

public class TestClass extends Base {

    @Test
    public void initTest() throws Exception {
        Runner r = new Runner();
        r.runInitTest();
        r.clientSocket.close();
    }

    @Test
    public void webParamTest() throws Exception {
        Runner r = new Runner();
        r.runInitTest();
        r.runWebParamTest();
    }

    @Test
    public void InitAndPayIncorrectMACTest() throws Exception {
        Runner r = new Runner();
        r.runInitTest();
        r.runWebParamTest();
        r.runPayIncorrectMACTest();
        r.clientSocket.close();
    }

    @Test
    public void e2eTest() throws Exception {
        Runner r = new Runner();
        r.runInitTest();
        r.runWebParamTest();
        r.runLoadTMK();
        r.runLoadKeys();
        r.runPayContactSuccessTest();
        r.runCancelTransactionTest();
        r.cutover();
    }
}