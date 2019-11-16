package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

    private static final String path = "textFiles/ete";

    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(System.out::println);



    }
}
