/**
*
* @author Mert Umul 
* <p>
*  Bu sınıf, dosya okunurken dosyanın içindeki fonksiyonlara ait değişkenleri tutmak için oluşturulmuştur.
*  Ben fonksiyonların yorum satırı, adi ve yorum satırı sayısını tutmak istediğimden, myFunction adlı bir sınıf oluşturdum.
*  Bu sınıfta fonksiyona ait olan yorum satırı değişkenleri sayısı gibi özellikleri tutuluyor. 
*  Her fonksiyon bulunduğunda bu sınıftan bir nesne oluşturuluyor ve fonksiyona ait olan özellikleri bu sınıf yardımıyla 
*  tutuyorum.Bir adet kurucu fonksiyonum var nesne oluşturulduğunda nesnenin adını functionName adlı değişkene atıyor ve
*  yorum satırı sayılarını otamatikmen 0 yapıyor.Ayrıca tuttuğum değikenlerin get() ve set() metodları var bunlar, benim 
*  işimi nesnenin adını ,yorum sayısını,yorumun içeriği gibi özellikleri ekrana getirmemi ve bunlara değer atamamı sağlıyor.
* 
* </p>
*/
package pdp;
import java.util.SplittableRandom;

public class myFunction {
//değişkenler
    private String functionName;
    private int numberOfCommentLines;
    private int numberOfMultipleCommentLines;
    private int numberOfJavaDoc;
    private String SingleLineComment;
    private String MultipleComment;
    private  String JavadocCommnet;

//kurucu fonksiyon
    public myFunction(String name) {
        this.numberOfCommentLines=0;
        this.numberOfJavaDoc=0;
        this.numberOfMultipleCommentLines=0;
        this.functionName=name;
    }
//fonksiyonun ismini döndür
    public String getFunctionName(){
        return functionName;
    }
//Tekli yorum satırlarının get() ve set() metodlatı
    public String getSingleLineComment(){return SingleLineComment;}
    public void setSingleLineComment (String comment){this.SingleLineComment=comment;}
//Çoklu yorum satırlarının get() ve set() metodlatı
    public  String getMultipleComment(){return MultipleComment;}
    public void setMultipleComment(String comment){this.MultipleComment=comment;}
//Javadoc yorum satırlarının get() ve set() metodlatı
    public String getJavadocCommnet(){return JavadocCommnet;}
    public void setJavadocCommnet(String commnet){this.JavadocCommnet=commnet;}

    //Tekli yorum satırlarının  sayısının get() ve set() metodlatı
    public void setNumberOfCommentLines(int numberOfCommentLines){this.numberOfCommentLines =numberOfCommentLines;}
    public int getNumberOfCommentLines(){return  numberOfCommentLines;}
    //Çoklu yorum satırlarının  sayısının get() ve set() metodlatı
    public void setNumberOfMultipleCommentLines(int numberOfMultipleCommentLines){this.numberOfMultipleCommentLines=numberOfMultipleCommentLines;}
    public int getNumberOfMultipleCommentLines(){return  numberOfMultipleCommentLines;}
    //Javadoc yorum satırlarının  sayısının get() ve set() metodlatı
    public  void setNumberOfJavaDoc(int numberOfJavaDoc){this.numberOfJavaDoc = numberOfJavaDoc;}
    public  int getNumberOfJavaDoc(){return  numberOfJavaDoc;}



}
