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

       // fileWorkDao.saveFileStat(calculateDataInFile(file));
        //FileStat f1 = calculateDataInFile(file);
        fileWorkDao.saveFileStat(file);
    }

    /*
    private FileStat calculateDataInFile(File file)
    {
        FileStat fileStat = new FileStat("name3",1,1,1,1);



        return fileStat;
    }
  */
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


