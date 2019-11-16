package org.example;


import org.junit.Test;
import org.testng.Assert;
import part3.entity.Element;
import part3.entity.elementType;
import part3.fileWork.TextBuilder;
import part3.fileWork.TextFileWorker;

import java.util.ArrayList;
import java.util.List;

public class TextBuilderTest {


    @Test
    public void replaceWordTest(){
        TextBuilder textBuilder = new TextBuilder();
        Element element1 = new Element();

        element1.setType(elementType.word);
        String word = "Hello";
        element1.setValue("Hello");

        Element element2 = new Element();

        element2.setType(elementType.word);
        element2.setValue("Word");

    }
}
