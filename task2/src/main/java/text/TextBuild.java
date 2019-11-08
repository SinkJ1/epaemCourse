package text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TextBuild {

    private static final Logger logger = LogManager.getLogger(TextBuild.class);
    private List<String> sentenceList = new ArrayList<>();
    private List<String> lineList = new ArrayList<>();
    private char charArray[];

    public void getText(String path){

        try{
            Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(lineList::add);
        }catch (IOException ex){
            logger.warn(ex);
        }

        System.out.println(lineList.toString());
        charArray = lineList.toString().toCharArray();
    }



    public List<String> lineParser(){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < charArray.length - 1;i++){
            stringBuilder.append(charArray[i]);
            if((charArray[i] == '.' || charArray[i] == '!' || charArray[i] == '?') && ((charArray[i+1] == ' ') || (String.valueOf(charArray[i+1]).matches("A-Z")))){
                stringBuilder.append(charArray[i]);
                sentenceList.add(stringBuilder.toString());
                i++;
               stringBuilder.setLength(0);
            }
        }
        return sentenceList;
    }


}
