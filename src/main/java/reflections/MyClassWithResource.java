package reflections;

// общий способ прочитать файл-ресурс произвольного формата, расположенный «рядом» с некоторым классом
//  файл «mydata.txt» должен быть расположен в том же каталоге, что и class-файл «MyClassWithResource.class».
import java.io.*;

public class MyClassWithResource {
    public static final String myTextResourceName= "mydata.txt";
    public static final String myTextResource;
    static {
        String s= "";
        try {
            InputStream stream = MyClassWithResource.class.getResourceAsStream(myTextResourceName);
            if (stream == null)
                throw new FileNotFoundException(myTextResourceName+" not found");
            StringBuffer sb = new StringBuffer(stream.available());
            InputStreamReader reader = new InputStreamReader(stream);
            char[] buf = new char[32768];
            int len;
            while ((len = reader.read(buf,0,buf.length))>=0) {
                sb.append(buf,0,len);
            }
            s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myTextResource= s;
    }
    public static void main(String[] args) {
        System.out.println("Loaded resource:");
        System.out.println(myTextResource);
    }
}
