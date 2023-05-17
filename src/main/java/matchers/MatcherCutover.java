package matchers;

public class MatcherCutover {

    private String cutoverEstablishingConnectionExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CUTOVER\",\n" +
            "    \"tag\": 165191996957294014,\n" +
            "    \"state\": \"EstablishingConnection\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 10,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cutoverSendingMessageExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CUTOVER\",\n" +
            "    \"tag\": 165191996957294014,\n" +
            "    \"state\": \"SendingMessage\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 7,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cutoverWaitingResponse = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CUTOVER\",\n" +
            "    \"tag\": 165191996957294014,\n" +
            "    \"state\": \"WaitingResponse\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cutoverExecutionCompletedSuccessExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CutoverOutput\",\n" +
            "    \"tag\": 165191996957294014,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"result\": \"Success\"\n" +
            "}";

    public String getCutoverEstablishingConnectionExample() {
        return cutoverEstablishingConnectionExample;
    }

    public String getCutoverSendingMessageExample() {
        return cutoverSendingMessageExample;
    }

    public String getCutoverWaitingResponse() {
        return cutoverWaitingResponse;
    }

    public String getCutoverExecutionCompletedSuccessExample() {
        return cutoverExecutionCompletedSuccessExample;
    }
}
