package matchers;

public class MatcherRefund {

    private String refundStartExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"Started\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundAwaitForCardExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.AwaitForCardOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"message\": \"Please insert your card\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"WAITFORCARD\"\n" +
            "    }\n" +
            "}";

    private String refundReadingCardExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"ReadingCard\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundContactExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.CardInsertedOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"entryMode\": \"Contact\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"CARD_INSERTED\"\n" +
            "    }\n" +
            "}";

    private String refundEstablishingConnectionExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"EstablishingConnection\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 10,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundSendingMessageExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"SendingMessage\",\n" +
            "    \"attempt\": 1,\n" +
            "    \"maxAttempts\": 7,\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundWaitingResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"WaitingResponse\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundReleasingCardExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"ReleasingCard\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    private String refundExecutionCompleteSuccessExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"rrn\": \"309017647368\",\n" +
            "    \"entryMode\": \"Contact\",\n" +
            "    \"cardBrand\": \"Mastercard\",\n" +
            "    \"paymentStatusResult\": \"TransactionApproved\",\n" +
            "    \"softDeclineRecommendation\": null,\n" +
            "    \"failureReason\": null,\n" +
            "    \"hostResponse\": \"[TransactionApproved | 000 | (000) Approved]\",\n" +
            "    \"approvedAmount\": null,\n" +
            "    \"cardFormIndicator\": \"Unknown\",\n" +
            "    \"internalId\": 11,\n" +
            "    \"autoReversalNeeded\": false\n" +
            "}";

    private String refundFinishExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TransactionProgressOutput\",\n" +
            "    \"command\": \"REFUND\",\n" +
            "    \"tag\": 725626185226958005,\n" +
            "    \"state\": \"Finished\",\n" +
            "    \"meanCode\": {\n" +
            "        \"code\": \"TRANSACTION_PROGRESS\"\n" +
            "    }\n" +
            "}";

    public String getRefundStartExample() {
        return refundStartExample;
    }

    public String getRefundAwaitForCardExample() {
        return refundAwaitForCardExample;
    }

    public String getRefundReadingCardExample() {
        return refundReadingCardExample;
    }

    public String getRefundContactExample() {
        return refundContactExample;
    }

    public String getRefundEstablishingConnectionExample() {
        return refundEstablishingConnectionExample;
    }

    public String getRefundSendingMessageExample() {
        return refundSendingMessageExample;
    }

    public String getRefundWaitingResponseExample() {
        return refundWaitingResponseExample;
    }

    public String getRefundReleasingCardExample() {
        return refundReleasingCardExample;
    }

    public String getRefundExecutionCompleteSuccessExample() {
        return refundExecutionCompleteSuccessExample;
    }

    public String getRefundFinishExample() {
        return refundFinishExample;
    }
}
