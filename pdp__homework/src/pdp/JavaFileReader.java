/**
*
* @author Mert Umul
* <p>
*  Bu class ta verilen dosyanın okuma , dosyanın içindeki yorum satırlarını ve sayısını bulma ,Dosyanın içerisindeki
*  fonksiyonları myFunction classından nesnelere çevirme ve bu nesnelere özelliklerini atama son olarak ekranda ne gösterileceği
*  kodlanmıştır.ReadFile() dosyasında Program.java classında verilen dosyanın içeriği okur onu da şöyle yapar.İlk olarak 
*  okuma işlemi sırasında kullanacağı değişkenleri tanımlar.Örnek vermek gerekirse bu fonksiyon tekli yorum satırları için ilk başta
*  currentSingleCommentLine ve numberOfSingleCommnetLine değişkenleri tanır ve başlangıç değerlerini sırasıyla null ve 0 verir.
*  Verilen dosyanın satırları okunması sırasında "//" ifadesi görülürse ve o satırı currentSingleCommentLine değikenine aktarır ve numberOfSingleCommnetLine
*  değerini bir arttırır.Son olarak o yorumun ait olduğu fonksiyon bittiğinde ise myFunction türünden bir nesne oluşturulur ve fonksiyonun adı verilir ve o nesnenin
*  değişkenlerine currentSingleCommentLine ve numberOfSingleCommnetLine atanır ki sonradan dosya yazma ve ekrana bastırma işleminde kullanılabilsin ondan sonra bu değerleri null ve 0 a dönderir ki farklı
*  fonksiyon kulannırken bu değerleri bir sorun yaşamasın diye.Bu işlemleri aynı şekilde coklu yorum satırı ve javadoc yorum satırları içinde yapar onlarda extradan yorum satırı fazla olabileceğinden "/*" yorum satırına girdiğinde 
*  bir boolean değişkenini true yapar bu sayede program yorum satırının içinde olduğunu anlar ve o yorum satırı  bittiğinde ise boolean ifadeyi false yapar ki fonksiyon 
*  yorumun bittiğini bilebilsin diye.Extra olarak bu fonksiyonun içinde okuduğu class ın adını bulur.Şuan hangi fonksiyonun bulması için bir fonksiyon yazdım onu sonra anlatıcam
*  son olarak bu fonksiyonun içinde eğer yorum satırlarının tutulduğu String değişkenler boş değilse içindeki değişkenler assignCommnets()yardımıyla ilgili  myFunction nesnelerine atanır.
*  Ondan bu string ve int değişkenler null 0 aktarılır yani sıfırlama işlemi yapılır.
*  
*  getFunctionName() fonksiyonu, Java dosyasında verilen bir satırdan fonksiyon adı ve parametrelerini belirlemek için kullanılır.
*  İlk olarak, satırın sonunda yer alan parantez içindeki karakter dizisi (parametreler) belirlenir.
*  Daha sonra, fonksiyon adı önceki boşluktan (veya noktadan) sonraki karakter dizisinden alınır. 
*  Fonksiyon adı ya da parametreler birden fazla satıra yayılmışsa, diğer satırları da okuyarak fonksiyon adı ve parametrelerin tamamını belirlemeye çalışır. 
*  Fonksiyon adı ve parametrelerin birleştirilmiş hali, Java dosyasındaki fonksiyonun tam adını oluşturur ve bu değer geri döndürülür. 
*  Fonksiyon adı ya da parametreler belirlenemezse, null değeri döndürülür.
*  
* assignFunction() Bu fonksiyon, bir dosya adı ve bir myFunction listesi alarak, dosyadaki her bir fonksiyon tanımını okuyarak myFunction sınıfının bir nesne örneğini yaratıp, listeye eklemektedir.
* Fonksiyon, önce dosyayı açarak BufferedReader nesnesi yaratır ve dosyayı okumaya başlar. Daha sonra her bir satırı okuyarak,
* eğer satırda bir fonksiyon tanımı varsa, getFunctionName() fonksiyonunu çağırarak fonksiyon adını ve parametrelerini okur ve myFunction sınıfından bir nesne yaratıp,
* bu nesneyi fonksiyon listesine ekler. Eğer dosya okuma işlemi sırasında bir IOException hatası oluşursa, bu hata dışarıya fırlatılır (throws IOException).
* 
* assignCommnets() Bu fonksiyon, bir myFunction listesi,mevcut fonksiyon adı, yorum metni, yorum tipi (tek satır, çoklu satır veya Javadoc) ve yorum satır sayısı bilgilerini alarak,
*  myFunction listesindeki ilgili fonksiyonun ilgili yorum tipine ait yorum bilgilerini günceller.
*  
*  processComments() Bu fonksiyon, bir myFunction listesi ve bir JavaFileWriter nesnesi alarak,
*  myFunction listesindeki her bir fonksiyona ait yorum bilgilerini JavaFileWriter nesnesi kullanarak onları txt dosyasına yazdırttır.
*  
*  setScreen() Bu fonksiyon myfunction listsindeki verileri gezerek ekrana istenilen formatta fonksiyonu ve yorum satır sayılarını yazdırtmak için kullanılır.
*  * </p>
*/

package pdp;

//import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;

public class JavaFileReader {

    private String fileName;
    JavaFileWriter writer = new JavaFileWriter();
    List<myFunction> functions = new ArrayList<>();


    public JavaFileReader(String filename) {
        this.fileName = filename;
    }

    public void ReadFile() {

        BufferedReader reader = null;
        try {
            assignFunction(fileName, functions);
           // getFunctionName();
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            String className = null;
            String currentFunction = null;
            String currentMultipleCommentLine = null;
            String currentSingleCommentLine = null;
            String currentJavaDocCommentLine = null;
            int numberOfSingleCommnetLine = 0;
            int numberOfMultipleCommentLine = 0;
            int numberOfJavadocCommentLine = 0;

            boolean inComment = false;
            boolean injavadocComment = false;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                //okunan şu anki sınıfın ismini bulma
                if (line.contains("class ")) {
                    int index = line.indexOf("class ");
                    className = line.substring(index + 6).split(" ")[0];
                 continue;
                }
                //tekli yorum satırı varsa gerekli atama işlemlerini yap
                if (line.contains("//") && !line.startsWith("*")){
                    numberOfSingleCommnetLine++;
                    if(currentSingleCommentLine != null)
                        currentSingleCommentLine += line.substring(line.indexOf("//") + 2)+"\n";
                    else
                        currentSingleCommentLine = line.substring(line.indexOf("//") + 2)+"\n";
                    continue;
                }


                //çoklu yorum satırı varsa gerekli atama işlemlerini yap
                if (line.contains("/*") && !line.contains("/**")) {
                    if (line.length() > 2) {
                        if (line.contains("*/")) {
                            currentMultipleCommentLine = line.substring(2, line.indexOf("*/")) + "\n";
                            numberOfMultipleCommentLine++;
                            continue;

                        } else {
                            currentMultipleCommentLine = line.substring(2) + "\n";
                            inComment = true;
                            continue;
                        }

                    } else {
                        inComment = true;
                        continue;
                    }

                }
                if (inComment) {
                    numberOfMultipleCommentLine++;
                    if (line.startsWith("*") && !line.startsWith("*/")){
                        if (currentMultipleCommentLine != null)
                            currentMultipleCommentLine += line.substring(1) + "\n";
                        else
                            currentMultipleCommentLine = line.substring(1) + "\n";
                    }

                    if (line.contains("*/")){
                        if (line.length() > 2){
                            if (currentMultipleCommentLine != null)
                                currentMultipleCommentLine += line.substring(0, line.indexOf("*/"));
                            else
                                currentMultipleCommentLine = line.substring(0, line.indexOf("*/"));
                        }

                        else
                            inComment = false;

                    }

                }


                //javadoc comment varsa gerekli atama işlemlerini yap
                if (line.contains("/**")) {
                    numberOfJavadocCommentLine++;
                    injavadocComment = true;
                    continue;
                }
                if (injavadocComment) {
                    if (line.startsWith("*") && !line.startsWith("*/")) {

                        if (currentJavaDocCommentLine == null){
                            currentJavaDocCommentLine = line.substring(1) + "\n";
                        }

                        else
                            currentJavaDocCommentLine += line.substring(1) + "\n";
                    }
                    if (line.contains("*/")) {
                        injavadocComment = false;
                    }
                }


                // Şuanki Fonksiyon bulma
                else if (line.contains("(") && line.contains(")") && (line.contains("public") || line.contains("private") || line.contains("protected") || line.contains("static"))) {
                    currentFunction = getFunctionName(line, reader);
                }else {
                    //tek satir yorumu varsa gerekli atama işlemelerini yap
                    if (currentSingleCommentLine != null) {
                        assignCommnets(functions, currentFunction, currentSingleCommentLine, 'S',numberOfSingleCommnetLine);
                        currentSingleCommentLine = null;
                        numberOfSingleCommnetLine=0;

                    }
                    //Çoklu  yorum satırı  varsa gerekli atama işlemelerini yap

                    if (currentMultipleCommentLine != null) {
                        assignCommnets(functions, currentFunction, currentMultipleCommentLine, 'M',numberOfMultipleCommentLine);
                        currentMultipleCommentLine = null;
                        numberOfMultipleCommentLine=0;
                    }
                    //Javadoc yorum satırı yorumu  varsa gerekli atama işlemelerini yap

                    if (currentJavaDocCommentLine != null) {
                        assignCommnets(functions, currentFunction, currentJavaDocCommentLine, 'J',numberOfJavadocCommentLine);
                        currentJavaDocCommentLine = null;
                        numberOfJavadocCommentLine=0;
                    }

                }
            }
            processComments(functions,writer);
            setScreen(functions,className);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    private static String getFunctionName(String line, BufferedReader reader) throws IOException {
        int endIndex = line.indexOf("(");
        int startIndex = line.lastIndexOf(" ", endIndex) + 1;

        if (startIndex < 0 || endIndex < 0 || startIndex >= endIndex) {
            // Hatalı satır, fonksiyon adı belirlenemiyor
            return null;
        }

        String functionName = line.substring(startIndex, endIndex);

        // Parametrelerin alınması
        int paramsStartIndex = endIndex + 1;
        int paramsEndIndex = line.indexOf(")", paramsStartIndex);

        if (paramsEndIndex < 0) {
            // Hatalı satır, parametreler belirlenemiyor
            return null;
        }

        String paramsString = line.substring(paramsStartIndex, paramsEndIndex).trim();

        // Eğer fonksiyon adı ya da parametreler birden fazla satıra yayıldıysa, diğer satırları da kontrol et
        while (functionName.endsWith(".") || functionName.endsWith(",") || paramsString.endsWith("\\")) {
            line = reader.readLine().trim();
            if (line != null) {
                functionName += line.replaceAll("\\s", "");
                paramsString += line.replaceAll("\\s", "");
            } else {
                break;
            }
        }

        return functionName + "(" + paramsString + ")";
    }

    private static void assignFunction(String fileName, List<myFunction> functions) throws IOException {


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Satırda bir fonksiyon tanımı var mı?
                if (line.contains("(") && line.contains(")") && (line.contains("public") || line.contains("private") || line.contains("protected") || line.contains("static"))) {
                    // Fonksiyon adı ve parametrelerin alınması
                    String functionNameAndParams = getFunctionName(line, reader);
                    if (functionNameAndParams != null) {
                        functions.add(new myFunction(functionNameAndParams));
                    }
                }
            }
        }

    }

    private void assignCommnets(List<myFunction> functions, String currentFunction, String comments, char type,int number) {

        for (myFunction function : functions) {
           if(currentFunction.equals(function.getFunctionName())){
               if(type =='S'){
                   function.setSingleLineComment(comments);
                   function.setNumberOfCommentLines(number);
               }

               else if(type == 'M'){
                   function.setMultipleComment(comments);
                   function.setNumberOfMultipleCommentLines(number);
               }

               else{
                   function.setJavadocCommnet(comments);
                   function.setNumberOfJavaDoc(number);
               }

           }
        }
    }

    public void processComments(List<myFunction> functions ,JavaFileWriter writer){

        for(myFunction function : functions){
            writer.WriteSingleLineComment(function.getSingleLineComment(),function.getFunctionName());
            writer.MultipleLineComment(function.getMultipleComment(),function.getFunctionName());
            writer.WriteJavadocComment(function.getJavadocCommnet(),function.getFunctionName());

        }
    }

    public void setScreen(List<myFunction> functions,String className){
        System.out.println("Sınıf: "+className);

        for(myFunction function : functions){
            System.out.println("        Fonksiyon: "+function.getFunctionName());
            System.out.println("                Tek Satır Yorum Sayısı:    "+function.getNumberOfCommentLines());
            System.out.println("                Çok Satırlı Yorum Sayısı:  "+function.getNumberOfMultipleCommentLines());
            System.out.println("                Javadoc Yorum Sayısı:      "+function.getNumberOfJavaDoc());
            System.out.println("____________________________________________");
        }

    }
}
