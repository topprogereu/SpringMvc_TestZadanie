package com.pasha.dev.controller;


import com.pasha.dev.myfile.FileStat;
import com.pasha.dev.service.FileCalculeService;
import com.pasha.dev.service.FileWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;


import java.io.*;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    FileWorkService fileWorkService;

    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public String provideUploadInfo() {
        System.out.println("KEK");
        return "result";
    }

    @PostMapping(value="/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        System.out.println("SUDA");
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File localFile = new File(System.getProperty("upload_location")+"/"+file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(localFile));
                stream.write(bytes);
                stream.close();

                FileStat d1 = new FileStat();
                d1 = FileCalculeService.calculeDataAboutFile(localFile);
                fileWorkService.saveFileStat(d1);

                return "File " + name + " was downoload in " + System.getProperty("upload_location")+"/"+file.getOriginalFilename();
            } catch (Exception e) {
                return "Oops, error " + name + " => " + e.getMessage();
            }
        } else {
            return "Download failed cause " + name + " is empty";
        }
    }

    @RequestMapping(value="/stat", method= RequestMethod.GET)
    @ResponseBody
    public List<FileStat> getStatAboutFiles(@RequestParam(name = "file_name", required = false) String file_name) {
        System.out.println("stat");
        return fileWorkService.getInfoAboutFile(file_name);
    }



}
