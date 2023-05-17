package Assertions;

import GsonObjects.ExampleOfResponseFromServer;

import static org.testng.AssertJUnit.assertEquals;

public interface Assertions {

    default void assertTypeEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Type - field is not matched", expected.getType(), actual.getType());
    }

    default void assertCommandEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Command - field is not matched", expected.getCommand(), actual.getCommand());
    }

    default void assertTagEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Tag - field is not matched", expected.getTag(), actual.getTag());
    }

    default void assertExecuteCodeEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Execute code - field is not matched", expected.getExecuteCode(), actual.getExecuteCode());
    }

    default void assertRRNEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("RRN - field is not matched", expected.getRrn(), actual.getRrn());
    }

    default void assertEntryModeEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Entry mode - field is not matched", expected.getEntryMode(), actual.getEntryMode());
    }

    default void assertCardBrandEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Card brand - field is not matched", expected.getCardBrand(), actual.getCardBrand());
    }

    default void assertPaymentStatusResultEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Payment status result - field is not matched", expected.getPaymentStatusResult(), actual.getPaymentStatusResult());
    }

    default void assertSoftDeclineRecommendationEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Soft decline recommendation - field is not matched", expected.getSoftDeclineRecommendation(), actual.getSoftDeclineRecommendation());
    }

    default void assertFailureReasonEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Failure reason - field is not matched", expected.getFailureReason(), actual.getFailureReason());
    }

    default void assertHostResponseEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals("Host response - field is not matched", expected.getHostResponse(), actual.getHostResponse());
    }

    default void assertApprovedAmountEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getApprovedAmount(), actual.getApprovedAmount());
    }

    default void assertCardFormIndicatorEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getCardFormIndicator(), actual.getCardFormIndicator());
    }

    default void assertInternalIdEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getInternalId(), actual.getInternalId());
    }

    default void assertAutoReversalNeededExpected(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getAutoReversalNeeded(), actual.getAutoReversalNeeded());
    }

    default void assertLoadedTerminalIDsEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getLoadedTerminalIDs(), actual.getLoadedTerminalIDs());
    }

    default void assertErrorDescriptionEquals(ExampleOfResponseFromServer expected, ExampleOfResponseFromServer actual){
        assertEquals(" field is not matched", expected.getErrorDescription(), actual.getErrorDescription());
    }
}
