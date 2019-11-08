package text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;


public class TextBuild {

    private static final Logger logger = LogManager.getLogger(TextBuild.class);

    public String getText(String path){


        String textArray = "";

        try(FileInputStream fis = new FileInputStream("textFiles/text.txt")){
            System.out.println("fis.available()");
        }catch (IOException e){
            logger.warn(e);
        System.out.println("-------------><");
        }

        return textArray;
    }


}
