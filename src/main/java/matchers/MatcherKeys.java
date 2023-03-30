package matchers;

public class MatcherKeys {
    private String establishingConnectionResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"KEYS\",\n" +
            "    \"tag\": 5510439305058152255,\n" +
            "    \"state\": \"EstablishingConnection\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 10,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String sendingMessageResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"KEYS\",\n" +
            "    \"tag\": 5510439305058152255,\n" +
            "    \"state\": \"SendingMessage\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 7,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String waitingResponse = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"KEYS\",\n" +
            "    \"tag\": 5510439305058152255,\n" +
            "    \"state\": \"WaitingResponse\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String executionCompletedSuccessResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.KeyExchangeOutput\",\n" +
            "    \"tag\": 5510439305058152255,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"result\": \"Success\"\n" +
            "}";

    public String getEstablishingConnectionResponseExample() {
        return establishingConnectionResponseExample;
    }

    public String getSendingMessageResponseExample() {
        return sendingMessageResponseExample;
    }

    public String getWaitingResponse() {
        return waitingResponse;
    }

    public String getExecutionCompletedSuccessResponseExample() {
        return executionCompletedSuccessResponseExample;
    }
}
