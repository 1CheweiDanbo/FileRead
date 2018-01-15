package util;
import java.lang.reflect.Method;
//实现打开浏览器并跳到指定网址的类
public class BrowserUtil {
    private void browse(String keyword) throws Exception {
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Windows")) {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.baidu.com/s?wd="+keyword);
        }
    }
}