package com.pasha.dev.dao;

import com.pasha.dev.filestats.FileStat;

import java.util.List;

public interface FileStatDao {

    void saveFileStat(FileStat file);

    List<FileStat> getInfoAboutFile(String name);


    List<FileStat> getAllFiles();
}
