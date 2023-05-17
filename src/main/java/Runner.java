import GsonObjects.ExampleOfResponseFromServer;
import com.google.gson.Gson;
import matchers.*;

import static org.testng.Assert.*;

public class Runner extends Client {

    MatcherPay mp = new MatcherPay();
    MatcherInit mi = new MatcherInit();
    MatcherWebParams mw = new MatcherWebParams();
    MatcherTMK mt = new MatcherTMK();
    MatcherKeys mk = new MatcherKeys();
    MatcherCancellation mCancel = new MatcherCancellation();
    MatcherCutover mc = new MatcherCutover();
    MatcherRefund mr = new MatcherRefund();
    Gson gson = new Gson();
    WorkerWithSQLite dBase = new WorkerWithSQLite();



    void runInitTest() throws Exception {
        //1 отправка команды
        System.out.println("Init - start\n");
        sendCommand(loadCommand("src/main/java/cmd/JSON_ARRAY_INIT-1679923207363.cmd"), dOut);
        //2 получение результата (их может быть несколько потому команд getOutput также может быть несколько)
        var res = getOutput(dIn);
            ExampleOfResponseFromServer expected = gson.fromJson(mi.getInitResponseExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getLoadedTerminalIDs(), expected.getLoadedTerminalIDs());
            System.out.println("Init - finish\n");
    }

    void runWebParamTest() throws Exception {
        System.out.println("Update web param - start\n");
        sendCommand(loadCommand("src/main/java/cmd/webParam.cmd"), dOut);
        var res = getOutput(dIn);
            ExampleOfResponseFromServer expected = gson.fromJson(mw.getWebParamExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getErrorDescription(), expected.getErrorDescription());
            System.out.println("\nUpdate web param - finish");
    }

    void runLoadTMK() throws Exception {
        System.out.println("\nLoad TMK - start\n");
        sendCommand(loadCommand("src/main/java/cmd/tmk.cmd"), dOut);
        var res = getOutput(dIn);
            ExampleOfResponseFromServer expected = gson.fromJson(mt.getTmkResponseExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getKcv(), expected.getKcv());
            System.out.println("\nLoad TMK - finish");
    }

    void runLoadKeys() throws Exception {
        System.out.println("\nLoad keys - start");
        sendCommand(loadCommand("src/main/java/cmd/keys.cmd"), dOut);
        var res = getOutput(dIn);
        System.out.println("Establishing connection");
            ExampleOfResponseFromServer expected = gson.fromJson(mk.getEstablishingConnectionResponseExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMaxAttempts(), expected.getMaxAttempts());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Sending message");
            expected = gson.fromJson(mk.getSendingMessageResponseExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMaxAttempts(), expected.getMaxAttempts());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Waiting response");
            expected = gson.fromJson(mk.getWaitingResponse(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Execution completed success");
            expected = gson.fromJson(mk.getExecutionCompletedSuccessResponseExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getResult(), expected.getResult());
        System.out.println("\nLoad keys - finish");
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
        assertEquals(mp.getAwaitCardExample(), res, "not equals: \n actual result: \n"
                + res + "\n should be \n" + mp.getAwaitCardExample());
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
        //1 отправка команды
        System.out.println("\nPAY contact - start\n");
        sendCommand(loadCommand("src/main/java/cmd/pay.cmd"), dOut);
        //2 получение результата (их может быть несколько потому команд getOutput также может быть несколько)
        //Вот тут судя по всему нужно TransactionProgress
        //Вставка карты
        var res = getOutput(dIn);
        System.out.println("Response received\n");
            ExampleOfResponseFromServer expected = gson.fromJson(mp.getStartedExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Wait for the card\n");
            expected = gson.fromJson(mp.getAwaitCardExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getMessage(), expected.getMessage());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Reading the card\n");
            expected = gson.fromJson(mp.getReadingCardExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("The card inserted - contact \n");
            expected = gson.fromJson(mp.getInsertedContactExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getEntryMode(), expected.getEntryMode());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Establishing connection \n");
            expected = gson.fromJson(mp.getEstablishConnectionExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMaxAttempts(), expected.getMaxAttempts());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Sending the message \n");
            expected = gson.fromJson(mp.getSendingMessageExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMaxAttempts(), expected.getMaxAttempts());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Waiting for response \n");
            expected = gson.fromJson(mp.getWaitingResponseExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
        System.out.println("Release the card \n");
            expected = gson.fromJson(mp.getReleaseCardExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
        res = getOutput(dIn);
            expected = gson.fromJson(mp.getPaySuccessResponseExamle(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
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
        assertEquals(mp.getFinishResponseExample(), res, "finishing error");
        System.out.println("Pay contact - finish\n");
        return actual;
    }

    ExampleOfResponseFromServer runCancelPaymentByIdTest(ExampleOfResponseFromServer payResp) throws Exception {
        System.out.println("\n\n pay and cancel - start\n");
        String cancelJson = "{\n" +
                "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CancellationInput\",\n" +
                "    \"tag\": 8348523488688107335,\n" +
                "    \"terminalID\": \"29413466\",\n" +
                "    \"lookup\": {\n" +
                "        \"type\": \"com.katemedia.android.lib.kate.payment.model.models.data.TransactionLookupByID\",\n" +
                "        \"internalTransactionID\": " + payResp.getInternalId() + "\n" +
                "    },\n" +
                "    \"newAmount\": null,\n" +
                "    \"reason\": \"customerCancellation\"\n" +
                "}";
        sendCommand(cancelJson, dOut);
        var res = getOutput(dIn);
            ExampleOfResponseFromServer expected = gson.fromJson(mCancel.getCancelEstablishingConnectionExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mCancel.getCancelEstablishingConnectionExample());
        res = getOutput(dIn);
            expected = gson.fromJson(mCancel.getCancelSendingMessageExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mCancel.getCancelSendingMessageExample());
        res = getOutput(dIn);
            expected = gson.fromJson(mCancel.getCancelWaitingResponse(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mCancel.getCancelWaitingResponse());
        res = getOutput(dIn);
            expected = gson.fromJson(mCancel.getCancelExecutionCompletedSuccessExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getRrn(), payResp.getRrn());
        System.out.println("\npay and cancel - finish\n");
        return actual;
    }

    void cutover() throws Exception {
        System.out.println("\ncutover - start\n");
        sendCommand(loadCommand("src/main/java/cmd/cutover.cmd"), dOut);
        var res = getOutput(dIn);
            ExampleOfResponseFromServer expected = gson.fromJson(mc.getCutoverEstablishingConnectionExample(), ExampleOfResponseFromServer.class);
            ExampleOfResponseFromServer actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mc.getCutoverEstablishingConnectionExample());
        res = getOutput(dIn);
            expected = gson.fromJson(mc.getCutoverSendingMessageExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mc.getCutoverSendingMessageExample());
        res = getOutput(dIn);
            expected = gson.fromJson(mc.getCutoverWaitingResponse(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getCommand(), expected.getCommand());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getState(), expected.getState());
            assertEquals(actual.getMeanCode().getMeanCode(), expected.getMeanCode().getMeanCode());
//        assertEquals(res, mc.getCutoverWaitingResponse());
        res = getOutput(dIn);
            expected = gson.fromJson(mc.getCutoverExecutionCompletedSuccessExample(), ExampleOfResponseFromServer.class);
            actual = gson.fromJson(res, ExampleOfResponseFromServer.class);
            assertEquals(actual.getType(), expected.getType());
            assertEquals(actual.getTag(), expected.getTag());
            assertEquals(actual.getExecuteCode(), expected.getExecuteCode());
            assertEquals(actual.getResult(), expected.getResult());
//        assertEquals(res, mc.getCutoverExecutionCompletedSuccessExample());
        System.out.println("\nCutover - finish\n");
    }

    void runRefund() throws Exception {
        System.out.println("\nrefund - start\n");
        sendCommand(loadCommand("src/main/java/cmd/refund.cmd"), dOut);
        var res = getOutput(dIn);
        assertEquals(res, mr.getRefundStartExample());
        System.out.println(res);
        res = getOutput(dIn);
        assertEquals(res, mr.getRefundAwaitForCardExample());
        System.out.println(res);
        res = getOutput(dIn);
        assertEquals(res, mr.getRefundReadingCardExample());
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
        res = getOutput(dIn);
        System.out.println(res);
    }
}
