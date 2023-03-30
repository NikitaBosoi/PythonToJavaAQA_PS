package GsonObjects;

public class ExampleOfResponseFromServer {

    private String type;
    private String command;
    private String tag;
    private String executeCode;
    private String rrn;
    private String entryMode;
    private String cardBrand;
    private String paymentStatusResult;
    private String softDeclineRecommendation;
    private String failureReason;
    private String hostResponse;
    private String approvedAmount;
    private String cardFormIndicator;
    private String internalId;
    private String autoReversalNeeded;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getExecuteCode() {
        return executeCode;
    }

    public void setExecuteCode(String executeCode) {
        this.executeCode = executeCode;
    }

    public String getPaymentStatusResult() {
        return paymentStatusResult;
    }

    public void setPaymentStatusResult(String paymentStatusResult) {
        this.paymentStatusResult = paymentStatusResult;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getHostResponse() {
        return hostResponse;
    }

    public void setHostResponse(String hostResponse) {
        this.hostResponse = hostResponse;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getSoftDeclineRecommendation() {
        return softDeclineRecommendation;
    }

    public void setSoftDeclineRecommendation(String softDeclineRecommendation) {
        this.softDeclineRecommendation = softDeclineRecommendation;
    }

    public String getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(String approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getCardFormIndicator() {
        return cardFormIndicator;
    }

    public void setCardFormIndicator(String cardFormIndicator) {
        this.cardFormIndicator = cardFormIndicator;
    }

    public String getAutoReversalNeeded() {
        return autoReversalNeeded;
    }

    public void setAutoReversalNeeded(String autoReversalNeeded) {
        this.autoReversalNeeded = autoReversalNeeded;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}
