package com.bitsai.utilities;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import com.qmetry.qaf.automation.testng.DataProviderException;

public class TestUtilities {

    public static long Page_Load_Timeout = 20;
    public static long ImplicitWat =20;

    public static String TESTDATA_SHEET_PATH="C:/Users/Ravi/MavenAuto/src/test/java/com/bitsai/testdata/testdata.xlsx";

    static Workbook book;
    static Sheet sheet;


    public static Object[][] getTestData(String sheetName) {
      //  FileInputStream file = null;
        try {
          FileInputStream  file = new FileInputStream(TESTDATA_SHEET_PATH);
      //  }

        /*catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
           assert file != null;*/
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
         System.out.println(sheet.getLastRowNum() + "--------" +
         sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                //data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue().trim();
                System.out.println(data[i][k]);
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        Object driver = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
       // FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    /*private static class FileUtils {
        public static void copyFile(File scrFile, File file) {
        }
    }

    /**
     * Get csv file data as Iterator of Map for each row data with column names
         * as key. It assumes first row as header row.
     *
     * @param strFile
     *            - csv file
     * @return Iterator of object array which contains Map
     /*
    public static List<Object[]> getCSVDataAsMap(String strFile) {
        ArrayList<Object[]> rows = new ArrayList<Object[]>();
        BufferedReader br = null;
        try {

            logger.info("loading csv data file: " + strFile);
            File csvFile = new File(strFile);
            br = new BufferedReader(new FileReader(csvFile));
            String strLine = "";
            char separatorChar = ',';
            // read comma separated file line by line
            // exclude blank lines and comments
            Object[] colsNames = null;
            while ((strLine = br.readLine()) != null) {
                if (!("".equalsIgnoreCase(strLine.trim()) || "#!".contains("" + strLine.trim().charAt(0)))) {
                    if (colsNames == null) {
                        colsNames = StringUtil.parseCSV(strLine, separatorChar);
                    } else {
                        Object[] cols = StringUtil.parseCSV(strLine, separatorChar);
                        Map<String, Object> map = new LinkedHashMap<String, Object>();
                        for (int i = 0; i < cols.length; i++) {
                            try {
                                map.put(colsNames[i].toString().trim(), cols[i]);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                logger.warn(String.format(
                                        "Missing column header for column[%d] in data file: %s. It will be included by lineNo",
                                        i + 1, strFile));
                                map.put(String.valueOf(i), cols[i]);

                            }
                        }
                        rows.add(new Object[] { map });

                    }
                } else if (strLine.contains("col.separator")) {
                    separatorChar = strLine.split("=")[1].trim().charAt(0);
                }
            }

        } catch (Exception e) {
            logger.error("Exception while reading csv file: " + strFile + e);
            throw new DataProviderException("Error while fetching data from " + strFile, e);

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return rows;
    }*/
}



