package GsonObjects.ISOMessages;

import java.util.Map;

public class ISOMessage {

    private int mti;

    private Map fields;

    public int getMti() {
        return mti;
    }

    public void setMti(int mti) {
        this.mti = mti;
    }

    public Map getFields() {
        return fields;
    }

    public void setFields(Map fields) {
        this.fields = fields;
    }
}
