package org.example;

import entity.Element;
import entity.elementType;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TextBuilderTest {


    @Test
    public void replaceTest(){

        Element element = new Element();
        element.setType(elementType.word);
        List<Object> objects = new ArrayList<>();

        objects.add(element);

        for(Object obj: objects){
            Element el = (Element)obj;
            System.out.println(el.getType());
            Assert.assertEquals(el,element);
        }

    }
}
