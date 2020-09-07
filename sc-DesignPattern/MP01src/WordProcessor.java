import java.util.HashMap;
import java.util.Map;

public class WordProcessor {
    private ISpellChecker spellChecker;
    private Map<String, DocConverter> docConverters;
    private String fileName;

    public WordProcessor (String fileName){
        this.fileName = fileName;
        this.docConverters = new HashMap<>();
    }
    public void addDocConverter(DocConverter converter){
        this.docConverters.put(converter.getExtension(), converter);
    }

    public void convertDocTo(String ext){
        if(docConverters.containsKey(ext)){
            docConverters.get(ext).save(fileName);
        }else{
            System.out.println(ext+"파일 형식을 지원하는 DocConverter가 없습니다.");
        }
    }

    public void setSpellChecker(ISpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }

    public void checkSpelling(){
        this.spellChecker.check();
    }
}
