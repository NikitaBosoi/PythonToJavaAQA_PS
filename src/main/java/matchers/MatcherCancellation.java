package matchers;

public class MatcherCancellation {

    private String cancelEstablishingConnectionExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CANCELLATION\",\n" +
            "    \"tag\": 8348523488688107335,\n" +
            "    \"state\": \"EstablishingConnection\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 10,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cancelSendingMessageExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CANCELLATION\",\n" +
            "    \"tag\": 8348523488688107335,\n" +
            "    \"state\": \"SendingMessage\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 7,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cancelWaitingResponse = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"CANCELLATION\",\n" +
            "    \"tag\": 8348523488688107335,\n" +
            "    \"state\": \"WaitingResponse\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String cancelExecutionCompletedSuccessExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CancellationOutput\",\n" +
            "    \"tag\": 8348523488688107335,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"rrn\": \"309082888742\"\n" +
            "}";

    public String getCancelEstablishingConnectionExample() {
        return cancelEstablishingConnectionExample;
    }

    public String getCancelSendingMessageExample() {
        return cancelSendingMessageExample;
    }

    public String getCancelWaitingResponse() {
        return cancelWaitingResponse;
    }

    public String getCancelExecutionCompletedSuccessExample() {
        return cancelExecutionCompletedSuccessExample;
    }
}
