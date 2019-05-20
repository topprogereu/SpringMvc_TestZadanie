package com.pasha.dev.dao;

import com.pasha.dev.myfile.FileStat;

import java.util.List;

public interface FileWorkDao {

    void saveFileStat(FileStat file);

    List<FileStat> getInfoAboutFile(String name);


    List<FileStat> getAllFiles();
}
