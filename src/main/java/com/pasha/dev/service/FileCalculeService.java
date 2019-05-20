package com.pasha.dev.service;

import com.pasha.dev.myfile.FileStat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCalculeService {

    public static FileStat calculeDataAboutFile(File file)
    {
        FileStat fs  = new FileStat();
        try(Stream<String> linesStream = Files.lines(Paths.get(file.getPath()))){

            List<String> linesList = linesStream.collect(Collectors.toList());
            int countLine = linesList.size();

            double sumWordsInFile = 0;
            for (String str: linesList) {
                sumWordsInFile += str.split(" +").length;
            }
            double avgWordInLines = sumWordsInFile/countLine;

            List<String> wordList = Arrays.asList(linesList.stream().collect(Collectors.joining(" ")).split(" +"));
            System.out.println(wordList);

            int maxLengthW = wordList.stream().max(Comparator.comparingInt(String::length)).get().length();
            int minLengthW = wordList.stream().min(Comparator.comparingInt(String::length)).get().length();

            fs = new FileStat(file.getName(),countLine,avgWordInLines,maxLengthW,minLengthW);

        }catch (Exception e){
            System.out.println("Exception in calcFileStat method");
        }

        return fs;
    }
}
