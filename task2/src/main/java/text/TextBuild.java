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
    private char charArray[];

    public List<String> getText(String path){

        List<String> sentenceList = new ArrayList<>();

        try{
            Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(line -> lineParser(line));
        }catch (IOException ex){
            logger.warn(ex);
        }
        return sentenceList;
    }

    private void addInArray(){
        
    }


    private void lineParser(String line){

        StringBuilder stringBuilder = new StringBuilder();
        charArray = line.toCharArray();

        for(int i = 0; i < charArray.length - 1;i++){
            stringBuilder.append(charArray[i]);
            if(((charArray[i] == '.' || charArray[i] == '!' || charArray[i] == '?') && charArray[i+1] == ' ') || i+2 == charArray.length){
                sentenceList.add(stringBuilder.toString());
                i++;
               stringBuilder.setLength(0);
            }
        }
    }

    public List<String> getSentenceList(){
        return sentenceList;
    }

}
