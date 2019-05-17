package com.pasha.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;



@Controller
public class MainController {

    @GetMapping("/")
    public String start(){
        System.out.println("Started");
        return "index";
    }

    @RequestMapping(value="/upload", method= RequestMethod.GET)
    @ResponseBody
    public String provideUploadInfo() {
        System.out.println("KEK");
        return "result";
    }

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    @ResponseBody
    public String provideSSSInfo() {
        System.out.println("ON GET HELLO");
        return "index";
    }

    @RequestMapping(value = "/uploadt", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        System.out.println("SUDA");
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }

    @PostMapping(value="/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        System.out.println("SUDA");
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();

                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }

}
