package text;

import java.util.List;

public class TextBuilder {

    char [] chars;

    public void replaceWords(int id, int length, List<String> sentenceList, String newString){
            StringBuilder stringBuilder = new StringBuilder();

            chars = sentenceList.get(id).toCharArray();
            for(int j = 0; j < chars.length; j++){
                if(String.valueOf(chars[j]).matches("[А-яA-z]")){
                    stringBuilder.append(chars[j]);
                    if(chars[j+1] == ' ' || chars[j+1] == ',' || chars[j+1] == ':' || chars[j+1] == ';' || chars[j+1] == ')'){
                        if(stringBuilder.length() == length) {
                            sentenceList.set(id, replace(id, stringBuilder, newString,sentenceList));
                        }
                            stringBuilder.setLength(0);
                    }
                }
            }
        sentenceList.stream().forEach(System.out::println);
    }

    private String replace(int id, StringBuilder word,String newString, List<String> sentenceList){
        String newSentence = sentenceList.get(id);
        return newSentence.replace(word,newString);
    }
}
