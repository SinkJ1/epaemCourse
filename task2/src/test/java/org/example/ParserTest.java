package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.entity.Element;
import part3.entity.elementType;
import part3.fileWork.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @Test
    public void elementsSplit_Test(){

        Parser parser = new Parser();

        List<String> stringList = new ArrayList<>();

        stringList.add("Hello, World!");

        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element(elementType.word,"Hello",5,false));
        elementList.add(new Element(elementType.other,",",1,false));
        elementList.add(new Element(elementType.blank," ",1,false));
        elementList.add(new Element(elementType.word,"World",5,false));
        elementList.add(new Element(elementType.punctuationMark,"!",1,true));

        Assert.assertEquals(parser.elementsSplit(stringList),elementList);
    }

}
