package com.pasha.dev.service;

import com.pasha.dev.dao.FileWorkDao;
import com.pasha.dev.myfile.FileStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileWorkService {

    @Autowired
    FileWorkDao fileWorkDao;

    public void saveFileStat(FileStat file) {
        fileWorkDao.saveFileStat(file);
    }

    public List<FileStat> getInfoAboutFile(String name)
    {
        if(name == null || name.isEmpty())
        {
            return fileWorkDao.getAllFiles();
        }
        else
        {
            return fileWorkDao.getInfoAboutFile(name);
        }

    }




}


