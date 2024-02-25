package utils.props;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataReader {
    private static Map<String, Map<String, String>> data;

    public static void init() {
        if (data == null) {
            data = new HashMap<>();
            loadData();
        }
    }

    private static void loadData() {
        //Read from excel -> apache POI
        // map<key,value> ---> map<Tc_name,Map<Col_name,Col_value>>
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Row header = sheet.getRow(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> colValues = new HashMap<>();
                String tcName = row.getCell(0).getStringCellValue();
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    Cell colHeader = header.getCell(j);
                    colValues.put(colHeader.getStringCellValue(), cell.getStringCellValue());
                }
                data.put(tcName, colValues);
            }
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> getData(String tc_name) {
        return data.get(tc_name);
    }
//  code to write in excel
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.createRow(2);
        Cell cell = row.createCell(0);
        cell.setCellValue("test user");
        workbook.close();
    }


}


// map<key,value> ---> map<Tc_name,Map<Col_name,Col_value>>
//map.get(key)
// a,b,c,d --->