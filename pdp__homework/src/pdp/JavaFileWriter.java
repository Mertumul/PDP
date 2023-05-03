/**
*
* @author Mert Umul 
* <p>
* Bu sınıfı,myFunction sınıfın nesnelerinin özelliklerini '.txt' dosyasına yazmak için kullanıyorum.
* Eğer  WriteSingleLineComment fonksiyonu çağrılırsa şuanki path ten bir geri dizine teksatir.txt diye bir
* .txt dosyası oluşturuyor ve okunulan dosyanın içinde geçen Tekli yorum satırlarını oraya yazıyor ayrıca o fonksiyona ait 
* tekli yorum satırı yoksa yani null ise yazma işlemi yapmıyor.
* Eğer  MultipleLineComment fonksiyonu çağrılırsa şuanki path ten bir geri dizine coksatir.txt diye bir
* .txt dosyası oluşturuyor ve okunulan dosyanın içinde geçen Çoklu yorum satırlarını oraya yazıyor ayrıca o fonksiyona ait 
* Çoklu yorum  satırı  yoksa yani null ise yazma işlemi yapmıyor.
* Eğer  WriteJavadocComment fonksiyonu çağrılırsa şuanki path ten bir geri dizine javadoc.txt diye bir
* .txt dosyası oluşturuyor ve okunulan dosyanın içinde geçen javadoc yorum satırlarını  oraya yazıyor ayrıca o fonksiyona ait 
* javadoc yorum  satırı  yoksa yani null ise yazma işlemi yapmıyor.
* </p>
*/
package pdp;
//paket tanımlamaları
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JavaFileWriter {
//dosyanın nereye oluşturulacağı burada yapmak istediğim program dist klasöründe çalışacağından asıl klasöre çıkartmak dosyaları
    private String singleLineCommentPath ="../teksatir.txt";
    private String MultipleCommentPath ="../coksatir.txt";
    private String JavadocCommentPath ="../javadoc.txt";

//Tekli yorum satırlarını teksatir.txt dosyasına yaz eğer gelen içerik boş değilse
    public void WriteSingleLineComment(String content,String name){
        if(content != null){
            try(FileWriter file = new FileWriter(singleLineCommentPath, true)){
                file.write("Fonksiyon:"+name+"\n");
                file.write("Comments:"+content);
                file.write("_______________________________________________________________"+"\n");
            }catch(IOException e){
                e.printStackTrace();
            }

        }


    }
  //Çoklu yorum satırlarını coksatir.txt dosyasına yaz eğer gelen içerik boş değilse

    public void MultipleLineComment(String content ,String name){
        if(content !=null){
            try(FileWriter file = new FileWriter(MultipleCommentPath, true)){
                file.write("Fonksiyon:"+name+"\n");
                file.write("Comments:"+content);
                file.write("_______________________________________________________________"+"\n");
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    //Javadoc yorum satırlarını javadoc.txt dosyasına yaz eğer gelen içerik boş değilse

   public void WriteJavadocComment(String content ,String name){
       if(content !=null){
           try(FileWriter file = new FileWriter(JavadocCommentPath, true)){
               file.write("Fonksiyon:"+name+"\n");
               file.write("Comments:"+content);
               file.write("_______________________________________________________________"+"\n");
           }catch(IOException e){
               e.printStackTrace();
           }
       }
   }

}
