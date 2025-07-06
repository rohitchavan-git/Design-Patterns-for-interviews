package adapter;


public class Simple {

    public static void main(String[] args) {

        LegacyXmlLogger legacyXmlLogger = new LegacyXmlLogger("<person><name>John</name><age>30</age></person>");
        JsonAdapter convertedJson = new XMlToJsonConvertor(legacyXmlLogger);
        System.out.println(convertedJson.convert());
    }


}
