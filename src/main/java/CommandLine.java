import com.lexicalscope.jewel.cli.Option;
import com.lexicalscope.jewel.cli.Unparsed;


public interface CommandLine {

    // Hocanın verdiği seçenekleri yaratmak için @Option etiketini kullanıyoruz
    //

    @Option(defaultValue = "10",shortName = "n") // entity sayısı için olan seçenek "-n" ile de ulaşılabilir. Parantez içi kısa adı
                             // belirtmek için.

    int getNumber();         // bu ise o seçeneğin değerine hangi method ile ulaşacağımızı belirlediğimiz kısım.
                             // Main sınıfında nasıl çalıştığını göreceksiniz.

    @Option(shortName = "e")
    String getEntity();

    @Option(shortName = "r")
    boolean isReverse();

    @Option(shortName = "i")
    boolean isIgnore();

    @Unparsed               // Bu seçeneklerden bağımsız bu ödevde okuyacağımız dosya için parse edilmeden alınacak
                            // argüman
    String fileName();      // Bu da dosyanın adına hangi method ile ulaşacağımızı belirttiğimiz kısım.

}
