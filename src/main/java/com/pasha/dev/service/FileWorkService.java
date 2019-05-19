package com.pasha.dev.service;

import com.pasha.dev.dao.FileStatDao;
import com.pasha.dev.dao.FileStatDaoImpl;
import com.pasha.dev.filestats.FileStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileWorkService {

    @Autowired
    FileStatDao fileStatDao;

    public void saveFileStat(File file) {
        fileStatDao.saveFileStat(calculateDataInFile(file));
    }


    private FileStat calculateDataInFile(File file)
    {
        FileStat fileStat = new FileStat();



        return new FileStat("name",1,1,1,1);
    }

    public List<FileStat> getInfoAboutFile(String name)
    {
        if(name == null || name.isEmpty())
        {
            return fileStatDao.getAllFiles();
        }
        else
        {
            return fileStatDao.getInfoAboutFile(name);
        }

    }




}


