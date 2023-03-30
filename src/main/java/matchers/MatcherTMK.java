package matchers;

public class MatcherTMK {

    private String tmkResponseExample = "{\n" +
            "    \"type\": \"com.katemedia.android.lib.kate.payment.model.models.TmkLoadingOutput\",\n" +
            "    \"tag\": 6430376734167306385,\n" +
            "    \"executeCode\": \"ExecutionCompletedSuccess\",\n" +
            "    \"kcv\": \"B5A146\"\n" +
            "}";

    public String getTmkResponseExample() {
        return tmkResponseExample;
    }
}
