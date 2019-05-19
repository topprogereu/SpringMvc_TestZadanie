package com.pasha.dev.dao;

import com.pasha.dev.filestats.FileStat;

public interface FileStatFunc {

    void saveFileStat(FileStat file);

    String getInfoAboutFile(String name);



}
