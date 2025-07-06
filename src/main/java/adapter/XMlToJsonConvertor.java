package adapter;

import org.json.JSONObject;
import org.json.XML;

public class XMlToJsonConvertor  implements  JsonAdapter{
    private final LegacyXmlLogger legacyXmlLogger;

    public XMlToJsonConvertor(LegacyXmlLogger legacyXmlLogger) {
        this.legacyXmlLogger = legacyXmlLogger;
    }





    @Override
    public String convert() {
        String xml = legacyXmlLogger.getXmlLogger();
        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(2); // pretty print
    }


}

