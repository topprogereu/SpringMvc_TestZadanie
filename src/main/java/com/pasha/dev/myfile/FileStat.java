package com.pasha.dev.myfile;

public class FileStat {

    private String name;
    private int countLines;
    private double averageCountLines;
    private int maxLengthWordsInFile;
    private int minLengthWordsInFile;

    public FileStat()
    {
    }
    public FileStat(String name, int countLines, double averageCountLines,
                    int maxLengthWordsInFile, int minLengthWordsInFile)
    {
        this.name = name;
        this.countLines = countLines;
        this.averageCountLines = averageCountLines;
        this.maxLengthWordsInFile = maxLengthWordsInFile;
        this.minLengthWordsInFile = minLengthWordsInFile;
    }

    public double getAverageCountLines() {
        return averageCountLines;
    }

    public int getCountLines() {
        return countLines;
    }

    public int getMaxLengthWordsInFile() {
        return maxLengthWordsInFile;
    }

    public int getMinLengthWordsInFile() {
        return minLengthWordsInFile;
    }

    public String getName() {
        return name;
    }

    public void setAverageCountLines(double averageCountLines) {
        this.averageCountLines = averageCountLines;
    }

    public void setCountLines(int countLines) {
        this.countLines = countLines;
    }

    public void setMaxLengthWordsInFile(int maxLengthWordsInFile) {
        this.maxLengthWordsInFile = maxLengthWordsInFile;
    }

    public void setMinLengthWordsInFile(int minLengthWordsInFile) {
        this.minLengthWordsInFile = minLengthWordsInFile;
    }

    public void setName(String name) {
        this.name = name;
    }
}
