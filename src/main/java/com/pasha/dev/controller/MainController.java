package com.pasha.dev.controller;


import com.pasha.dev.filestats.FileStat;
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

//    @GetMapping("/")
//    public String start(){
//        System.out.println("Started");
//        return "index";
//    }

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

                fileWorkService.saveFileStat(localFile);



                return "File " + name + " was download in " + System.getProperty("upload.location")+"/"+file.getOriginalFilename();
            } catch (Exception e) {
                return "Yo yo error " + name + " => " + e.getMessage();
            }
        } else {
            return "Download failed " + name + " because file was empty";
        }
    }



}
