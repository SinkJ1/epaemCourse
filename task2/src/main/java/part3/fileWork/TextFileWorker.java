package part3.fileWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class TextFileWorker {

    private static final Logger logger = LogManager.getLogger(TextFileWorker.class);

    public List<String> readText(String path){

        List<String> lineList = null;

        try{
            lineList = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        }catch (IOException ex){
            logger.warn(ex);
        }
        return lineList;
    }

    public void writeText(List<String> text, String path){
        try{
            Files.write(Paths.get(path), text);
        }catch (IOException ex){
            logger.warn(ex);
        }
    }

}
