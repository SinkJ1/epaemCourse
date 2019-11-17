package org.example;


import org.testng.Assert;
import org.testng.annotations.Test;
import part3.entity.Element;
import part3.entity.Sentence;
import part3.entity.elementType;
import part3.fileWork.TextBuilder;

import java.util.ArrayList;
import java.util.List;

public class TextBuilderTest {


    @Test
    public void replaceWordTest(){
        TextBuilder tb = new TextBuilder();

        List<Sentence> elementList = new ArrayList<>();

        elementList.add(new Sentence());

        List<Sentence> newElementList = new ArrayList<>();

        Assert.assertEquals(tb.replaceWord(2,3,"new Word",elementList), newElementList);

    }

    @Test
    public void buildSentenceTest(){

        TextBuilder tb = new TextBuilder();

        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element(elementType.word,"Hello",5,false));
        elementList.add(new Element(elementType.other,",",1,false));
        elementList.add(new Element(elementType.blank," ",1,false));
        elementList.add(new Element(elementType.word,"World",5,false));
        elementList.add(new Element(elementType.punctuationMark,"!",1,true));

        Sentence sentence = new Sentence();

        sentence.setElementList(elementList);
        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(sentence);

        Assert.assertEquals(tb.buildSentence(elementList),sentenceList);
    }

    @Test
    public void textBuildTest(){

        TextBuilder tb = new TextBuilder();

        List<Element> elementList = new ArrayList<>();

        String string = "Hello, World!";

        elementList.add(new Element(elementType.word,"Hello",5,false));
        elementList.add(new Element(elementType.other,",",1,false));
        elementList.add(new Element(elementType.blank," ",1,false));
        elementList.add(new Element(elementType.word,"World",5,false));
        elementList.add(new Element(elementType.punctuationMark,"!",1,true));

        Sentence sentence = new Sentence();

        sentence.setElementList(elementList);
        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(sentence);

        Assert.assertEquals(tb.textBuild(sentenceList).get(0),string);

    }

}
