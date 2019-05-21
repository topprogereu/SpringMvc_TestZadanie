package com.pasha.dev.service;

import com.pasha.dev.myfile.FileStat;

import java.io.File;
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

            List<String> wordAllList = new ArrayList<>();
            for(String line: linesList)
            {
                String [] arrayWordInLine = line.split(" +");
                for(String s : arrayWordInLine)
                    wordAllList.add(s);
            }

            wordAllList.sort((s1, s2) -> s1.length() - s2.length());
            int minLengthW= (wordAllList.get(0)).length();
            int maxLengthW= (wordAllList.get(wordAllList.size()-1)).length();

            fs = new FileStat(file.getName(),countLine,avgWordInLines,maxLengthW,minLengthW);

        }catch (Exception e){
            System.out.println("Exception in calcFileStat method");
        }

        return fs;
    }
}
