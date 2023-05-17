import GsonObjects.ExampleOfResponseFromServer;
import GsonObjects.ISOMessages.ISOMessage;
import org.testng.annotations.Test;

public class TestClass extends Base {

    @Test
    public void webParamTest() throws Exception {
        Runner r = new Runner();
        r.runWebParamTest();
    }

    @Test
    public void initTest() throws Exception {
        Runner r = new Runner();
        r.runWebParamTest();
        r.runInitTest();
    }

    @Test
    public void RSBTMKTest() throws Exception {
        Runner r = new Runner();
        r.runLoadTMK();
    }

    @Test
    public void loadKeysTest() throws Exception {
        Runner r = new Runner();
        r.runWebParamTest();
        r.runLoadTMK();
        r.runInitTest();
        r.runLoadKeys();
    }

    @Test
    public void payTest() throws Exception {
        Runner r = new Runner();
        r.runWebParamTest();
        r.runLoadTMK();
        r.runLoadKeys();
        r.runInitTest();
        ExampleOfResponseFromServer payResp = r.runPayContactSuccessTest();
        r.dBase.getDB();
        ISOMessage ISORequest = r.dBase.selectISOMessageRequest("Request", payResp.getInternalId());
        ISOMessage ISOResponse = r.dBase.selectISOMessageRequest("Response", payResp.getInternalId());
        r.dBase.assertISOPAYRequestResponse(ISORequest, ISOResponse);
        r.runCancelPaymentByIdTest(payResp);
        r.dBase.getDB();
        ISORequest = r.dBase.selectReversalISOMessagesOfTransaction("Request", payResp.getInternalId());
        ISOResponse = r.dBase.selectReversalISOMessagesOfTransaction("Response", payResp.getInternalId());
        r.dBase.assertISOCancelRequestResponse(ISORequest, ISOResponse);
    }

    @Test
    public void e2eTest() throws Exception {

    }
}