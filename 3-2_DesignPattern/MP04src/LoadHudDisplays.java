import java.io.*;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{

    private String filename;
    public LoadHudDisplays(String filename){
        this.filename = filename;
    }
    @Override
    public ArrayList<String> load() {
        ArrayList<String> list = new ArrayList<>();
        File file = new File("./"+filename);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = reader.readLine()) != null){
                list.add(line);
            }
            reader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
