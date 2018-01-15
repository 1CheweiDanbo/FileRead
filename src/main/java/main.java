import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static java.lang.Thread.sleep;


public class main{
    public static void main(String[] args) throws Exception  {

        File excelFile = new File("C:\\Users\\chewei\\Desktop\\part-time\\task20180112.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = wb.getSheetAt(0);
        List<String> list = new ArrayList<String>();

        for (Row row : sheet) {
            for (Cell cell : row) {
                String value = cell.getStringCellValue().toString();
                if(value != ""){
                    list.add(value);
                }
            }
        }
        list = ListReverse((ArrayList) list);
        for(int i= 1000;i<1050;i++){
            int index = list.get(i).indexOf("招聘");
            if(index > -1)
            browse(list.get(i).substring(0,index));
          sleep(2000);
        }
    }
    public static  List ListReverse(ArrayList al){
        List<String> list = new ArrayList<String>();
        Collections.reverse(al);
        Iterator it = al.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            list.add(str);
        }
        return list;
    }
    public static void browse(String keyword) throws Exception {
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Windows")) {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.baidu.com/s?wd="+keyword);
        }
    }
}
