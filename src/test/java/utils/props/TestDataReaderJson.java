package utils.props;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestDataReaderJson {
   private static JSONObject testData;

    public static void init() {
        if (testData == null){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("src/test/resources/TestData.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            JSONTokener jsonTokener = new JSONTokener(fileInputStream);
            testData = new JSONObject(jsonTokener);
        }
    }

    public static JSONObject getTestData(String tc_name){
        return testData.getJSONObject(tc_name);
    }
}
