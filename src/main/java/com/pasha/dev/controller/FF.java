package com.pasha.dev.controller;

import com.pasha.dev.filestats.FileStat;
import com.pasha.dev.service.FileWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FF {

    @Autowired
    FileWorkService fileWorkService;

    @RequestMapping(value="/stat", method= RequestMethod.GET)
    public List<FileStat> getStatAboutFiles(@RequestParam(name = "file_name") String file_name) {
        System.out.println("stat");
        return fileWorkService.getInfoAboutFile(file_name);
    }
}
