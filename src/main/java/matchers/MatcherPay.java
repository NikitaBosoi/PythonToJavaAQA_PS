package matchers;

public class MatcherPay {

    private String jsonArrayInitOutputMessageExample ="{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.JsonArrayInitOutput\",\n" +
            "    \"tag\": 371164988992454422,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"loadedTerminalIDs\": [\n" +
            "        \"29413466\"\n" +
            "    ]\n" +
            "}";

    private String startedExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"Started\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String awaitCardExample= "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.AwaitForCardOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"message\": \"Please insert your card\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"WAITFORCARD\"\n" +
            "    }\n" +
            "}";

    private String readingCardExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"ReadingCard\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String insertedContactExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CardInsertedOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"entryMode\": \"Contact\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"CARD_INSERTED\"\n" +
            "    }\n" +
            "}";

    private String establishConnectionExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"EstablishingConnection\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 10,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String sendingMessageExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"SendingMessage\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 7,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String waitingResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"WaitingResponse\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String releaseCardExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"ReleasingCard\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String incorrectMACResponseExample= "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"executeCode\": \"ExecutionCompletedError\",\n" +
            "    \"rrn\": \"308711203333\",\n" +
            "    \"entryMode\": \"Contact\",\n" +
            "    \"cardBrand\": null,\n" +
            "    \"paymentStatusResult\": \"SystemError\",\n" +
            "    \"softDeclineRecommendation\": null,\n" +
            "    \"failureReason\": \"Transaction completion error.\",\n" +
            "    \"hostResponse\": \"[SystemError | 916 | (916) Decline reason message: MAC incorrect]\",\n" +
            "    \"approvedAmount\": null,\n" +
            "    \"cardFormIndicator\": \"Unknown\",\n" +
            "    \"internalId\": 15,\n" +
            "    \"autoReversalNeeded\": false\n" +
            "}";

    private String paySuccessResponseExamle = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"rrn\": \"308802571445\",\n" +
            "    \"entryMode\": \"Contact\",\n" +
            "    \"cardBrand\": \"Mastercard\",\n" +
            "    \"paymentStatusResult\": \"TransactionApproved\",\n" +
            "    \"softDeclineRecommendation\": null,\n" +
            "    \"failureReason\": null,\n" +
            "    \"hostResponse\": \"[TransactionApproved | 000 | (000) Approved]\",\n" +
            "    \"approvedAmount\": null,\n" +
            "    \"cardFormIndicator\": \"Unknown\",\n" +
            "    \"internalId\": 29,\n" +
            "    \"autoReversalNeeded\": false\n" +
            "}";

    private String finishResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"PAY\",\n" +
            "    \"tag\": 4305710464068981555,\n" +
            "    \"state\": \"Finished\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";
    public String getJsonArrayInitOutputMessageExample(){
        return jsonArrayInitOutputMessageExample;
    }

    public String getStartedExample() {
        return startedExample;
    }

    public String getAwaitCardExample() {
        return awaitCardExample;
    }

    public String getReadingCardExample() {
        return readingCardExample;
    }

    public String getInsertedContactExample() {
        return insertedContactExample;
    }

    public String getEstablishConnectionExample() {
        return establishConnectionExample;
    }

    public String getSendingMessageExample() {
        return sendingMessageExample;
    }

    public String getWaitingResponseExample() {
        return waitingResponseExample;
    }

    public String getReleaseCardExample() {
        return releaseCardExample;
    }

    public String getIncorrectMACResponseExample() {
        return incorrectMACResponseExample;
    }

    public String getFinishResponseExample() {
        return finishResponseExample;
    }

    public String getPaySuccessResponseExamle() {
        return paySuccessResponseExamle;
    }

    public void MatchJSOARRAYINIT(String res) throws Exception {
        getJsonArrayInitOutputMessageExample();
        if(!res.equals(jsonArrayInitOutputMessageExample)) {
            System.out.println(res);
            System.out.println(jsonArrayInitOutputMessageExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateStarted(String res) throws Exception {
        getStartedExample();
        if(!res.equals(startedExample) )
        {
            System.out.println(res);
            System.out.println(startedExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateAwaitForCard(String res) throws Exception {
        getAwaitCardExample();
        if(!res.equals(awaitCardExample) )
        {
            System.out.println(res);
            System.out.println(awaitCardExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateReadingCard(String res) throws Exception {
        getReadingCardExample();
        if(!res.equals(readingCardExample) )
        {
            System.out.println(res);
            System.out.println(readingCardExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateCardInsertedContact(String res) throws Exception {
        getInsertedContactExample();
        if(!res.equals(insertedContactExample) )
        {
            System.out.println(res);
            System.out.println(insertedContactExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateEstablishingConnection(String res) throws Exception {
        getEstablishConnectionExample();
        if(!res.equals(establishConnectionExample) )
        {
            System.out.println(res);
            System.out.println(establishConnectionExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateSendingMessage(String res) throws Exception {
        getSendingMessageExample();
        if(!res.equals(sendingMessageExample) )
        {
            System.out.println(res);
            System.out.println(sendingMessageExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateWaitingResponse(String res) throws Exception {
        getWaitingResponseExample();
        if(!res.equals(waitingResponseExample) )
        {
            System.out.println(res);
            System.out.println(waitingResponseExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateReleasingCard(String res) throws Exception {
        getReleaseCardExample();
        if(!res.equals(releaseCardExample) )
        {
            System.out.println(res);
            System.out.println(releaseCardExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateTransactionOutputMACIncorrect(String res) throws Exception {
        getIncorrectMACResponseExample();
        if(!res.equals(incorrectMACResponseExample) )
        {
            System.out.println(res);
            System.out.println(incorrectMACResponseExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }

    public void matchTransactionStateFinishTransaction(String res) throws Exception {
        getFinishResponseExample();
        if(!res.equals(finishResponseExample) )
        {
            System.out.println(res);
            System.out.println(finishResponseExample);
            throw new Exception("Result is not equal to the expected one");
        }
    }
}
