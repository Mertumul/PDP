/**
*
* @author Mert Umul 
* <p>
* Bu class programın çalışmaya başladığı ana classtır. Bu class bir Java dosyasının yolunu kullanıcının programı 
* çalıştırırken komut satırı aracılığıyla girdiği bir parametre olarak alır.
*  Ardından, bu dosyanın okunması için JavaFileReader sınıfına gönderir ardından ReadFile() fonksiyonunu çağırır.
* </p>
*/

package pdp;

import java.io.*;
import java.util.List;
public class Program {
    public static void main(String[] args){
        if (args.length == 0) {
            System.out.println("Usage: java -jar Program.java <file_path>");
            System.exit(1);
        }
        String filePath = args[0];

        JavaFileReader file =new JavaFileReader(filePath);
        file.ReadFile();
    }
}
