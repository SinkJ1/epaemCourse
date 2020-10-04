package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.fileWork.TextFileWorker;

import java.util.ArrayList;
import java.util.List;

public class TextFileWorkerTest {

    @Test
    public void testRead(){
        String path = "textFiles/TestTextFile";
        TextFileWorker tfw = new TextFileWorker();
        Assert.assertEquals(tfw.readText(path).get(0),"Hello World!");
    }

    @Test
    public void testWrite(){
        String path = "textFiles/TestTextFile2";
        TextFileWorker tfw = new TextFileWorker();
        List<String> list = new ArrayList<>();
        list.add("Hello World!");
        tfw.writeText(list,path);
        Assert.assertEquals(tfw.readText(path).get(0),"Hello World!");
    }

}
