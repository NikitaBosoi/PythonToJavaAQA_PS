import GsonObjects.ExampleOfResponseFromServer;
import com.google.gson.Gson;
import matchers.*;

import static org.testng.Assert.*;

public class Runner extends BaseForTest{

    MatcherPay mp = new MatcherPay();
    MatcherInit mi = new MatcherInit();
    MatcherWebParams mw = new MatcherWebParams();
    MatcherTMK mt = new MatcherTMK();
    MatcherKeys mk = new MatcherKeys();


    void runInitTest() throws Exception {
        //1 отправка команды
        sendCommand(loadCommand("src/main/java/cmd/JSON_ARRAY_INIT-1679923207363.cmd"), dOut);
        //2 получение результата (их может быть несколько потому команд getOutput также может быть несколько)
        var res = getOutput(dIn);
        //3 тут сравнивать с шаблоном
        assertEquals(res,mi.getInit());
    }

    void runWebParamTest() throws Exception {
        sendCommand(loadCommand("src/main/java/cmd/webParam.cmd"), dOut);
        var res = getOutput(dIn);
        assertEquals(res, mw.getWebParamExample());
    }

    void runLoadTMK() throws Exception {
        sendCommand(loadCommand("src/main/java/cmd/tmk.cmd"), dOut);
        var res = getOutput(dIn);
        assertEquals(res, mt.getTmkResponseExample());
    }

    void runLoadKeys() throws Exception {
        sendCommand(loadCommand("src/main/java/cmd/keys.cmd"), dOut);
        var res = getOutput(dIn);
        assertEquals(res, mk.getEstablishingConnectionResponseExample());
        res = getOutput(dIn);
        assertEquals(res, mk.getSendingMessageResponseExample());
        res = getOutput(dIn);
        assertEquals(res, mk.getWaitingResponse());
        res = getOutput(dIn);
        assertEquals(res, mk.getExecutionCompletedSuccessResponseExample());

    }

    void runPayIncorrectMACTest() throws Exception {
        Gson gson = new Gson();
        //1 отправка команды
        System.out.println("PAY");
        sendCommand(loadCommand("src/main/java/cmd/pay.cmd"), dOut);

        //2 получение результата (их может быть несколько потому команд getOutput также может быть несколько)
        //Вот тут судя по всему нужно TransactionProgress
        //Вставка карты
        var res = getOutput(dIn);
        System.out.println("Response received\n");
        assertEquals(mp.getStartedExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getStartedExample());
        res = getOutput(dIn);
        assertEquals(mp.getAwaitExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getAwaitExample());
        System.out.println("Wait for the card\n");
        res = getOutput(dIn);
        assertEquals(mp.getReadingCardExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getReadingCardExample());
        System.out.println("Reading the card\n");
        res = getOutput(dIn);
        assertEquals(mp.getInsertedContactExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getInsertedContactExample());
        System.out.println("The card inserted - contact \n");
        res = getOutput(dIn);
        assertEquals(mp.getEstablishConnectionExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getEstablishConnectionExample() + "\n");
        System.out.println("Establishing connectin \n");
        res = getOutput(dIn);
        assertEquals(mp.getSendingMessageExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getSendingMessageExample());
        System.out.println("Sending the message \n");
        res = getOutput(dIn);
        assertEquals(mp.getWaitingResponseExample(), res, "\nwaiting response error\n");
        System.out.println("Waiting for response \n");
        res = getOutput(dIn);
        assertEquals(mp.getReleaseCardExample(), res,"\nreleasing card error\n");
        System.out.println("Release the card \n");
        res = getOutput(dIn);
        System.out.println(res);
        ExampleOfResponseFromServer expected = gson.fromJson(mp.getIncorrectMACResponseExample(), ExampleOfResponseFromServer.class);
        ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
        assertEquals(actual.getCommand(), expected.getCommand());
        assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
        assertEquals(actual.getFailureReason(), expected.getFailureReason());
        assertEquals(actual.getTag(), expected.getTag());
        assertEquals(actual.getType(), expected.getType());
        assertEquals(actual.getHostResponse(), expected.getHostResponse());
        assertEquals(actual.getPaymentStatusResult(), expected.getPaymentStatusResult());
        res = getOutput(dIn);
        assertEquals(mp.getFinishResponseExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getFinishResponseExample());
        System.out.println("Finished \n");
    }
    ExampleOfResponseFromServer runPayContactSuccessTest() throws Exception {
        Gson gson = new Gson();
        //1 отправка команды
        System.out.println("PAY contact");
        sendCommand(loadCommand("src/main/java/cmd/pay.cmd"), dOut);

        //2 получение результата (их может быть несколько потому команд getOutput также может быть несколько)
        //Вот тут судя по всему нужно TransactionProgress
        //Вставка карты
        var res = getOutput(dIn);
        System.out.println("Response received\n");
        assertEquals(mp.getStartedExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getStartedExample());
        res = getOutput(dIn);
        assertEquals(mp.getAwaitExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getAwaitExample());
        System.out.println("Wait for the card\n");
        res = getOutput(dIn);
        assertEquals(mp.getReadingCardExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getReadingCardExample());
        System.out.println("Reading the card\n");
        res = getOutput(dIn);
        assertEquals(mp.getInsertedContactExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getInsertedContactExample());
        System.out.println("The card inserted - contact \n");
        res = getOutput(dIn);
        assertEquals(mp.getEstablishConnectionExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getEstablishConnectionExample() + "\n");
        System.out.println("Establishing connectin \n");
        res = getOutput(dIn);
        assertEquals(mp.getSendingMessageExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getSendingMessageExample());
        System.out.println("Sending the message \n");
        res = getOutput(dIn);
        assertEquals(mp.getWaitingResponseExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getWaitingResponseExample());
        System.out.println("Waiting for response \n");
        res = getOutput(dIn);
        assertEquals(mp.getReleaseCardExample(), res, "releasing card error");
        System.out.println("Release the card \n");
        res = getOutput(dIn);
        ExampleOfResponseFromServer expected = gson.fromJson(mp.getPaySuccessResponseExamle(), ExampleOfResponseFromServer.class);
        ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
        assertEquals(actual.getType(), expected.getType());
        assertEquals(actual.getCommand(), expected.getCommand());
        assertEquals(actual.getTag(), expected.getTag());
        assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
        assertEquals(actual.getPaymentStatusResult(), expected.getPaymentStatusResult());
        assertEquals(actual.getSoftDeclineRecommendation(), expected.getSoftDeclineRecommendation());
        assertEquals(actual.getFailureReason(), expected.getFailureReason());
        assertEquals(actual.getHostResponse(), expected.getHostResponse());
        assertEquals(actual.getApprovedAmount(), expected.getApprovedAmount());
        assertEquals(actual.getCardFormIndicator(), expected.getCardFormIndicator());
        assertEquals(actual.getAutoReversalNeeded(), expected.getAutoReversalNeeded());
        res = getOutput(dIn);
        assertEquals(mp.getFinishResponseExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getFinishResponseExample());
        System.out.println("Finished \n");
        return actual;
    }

    void runCancelTransactionTest() throws Exception {
        String cancelJson = "{\n" +
                "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CancellationInput\",\n" +
                "    \"tag\": 8348523488688107335,\n" +
                "    \"terminalID\": \"29413466\",\n" +
                "    \"lookup\": {\n" +
                "        \"type\": \"com.katemedia.android.lib.kate.payment.model.models.data.TransactionLookupByID\",\n" +
                "        \"internalTransactionID\": " + runPayContactSuccessTest().getInternalId() + "\n" +
                "    },\n" +
                "    \"newAmount\": null,\n" +
                "    \"reason\": \"customerCancellation\"\n" +
                "}";
        sendCommand(cancelJson, dOut);
        var res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
    }

    void cutover() throws Exception {
        sendCommand(loadCommand("src/main/java/cmd/cutover.cmd"), dOut);
        var res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
    }
}
