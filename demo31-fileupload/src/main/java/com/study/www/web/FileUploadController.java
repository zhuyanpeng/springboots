package com.study.www.web;

import com.study.www.model.FileUpload;
import com.study.www.model.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/3/1- 15:52
 * @Version: V1.0
 * @Modified By:
 **/
@Controller
@RequestMapping("/")
public class FileUploadController {

    @Autowired
    FileUploadRepository fileUploadRepository;



    @PostMapping("fileUpload")
    @ResponseBody
    public String uploadFile(@RequestParam("file")MultipartFile file){
        FileUpload fileUpload = new FileUpload();
        try {
            byte[] bytes = file.getBytes();
            fileUpload.setFiles(bytes);
            fileUpload.setFileName(file.getOriginalFilename());
            fileUploadRepository.save(fileUpload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";

    }


    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "good!good!study!day!day!up!";
    }

    private final static String FORCEDOWNLOAD="application/force-download";
    private final static String HEADERDOWNLOAD="Content-Disposition";

    @GetMapping("download/{id}")
    public String download(@PathVariable("id")Long id, HttpServletResponse response){
        Optional<FileUpload> fileUploadOptional = fileUploadRepository.findById(id);
        if (fileUploadOptional!=null && fileUploadOptional.get()!=null){
            FileUpload fileUpload = fileUploadOptional.get();
            //设置强制下载不打开
            response.setContentType(FORCEDOWNLOAD);
            //设置文件名
            response.addHeader(HEADERDOWNLOAD,"attachment;fileName="+fileUpload.getFileName());
            //定时一个缓存输出流去慢慢的下载
            byte[] fileBytes = fileUpload.getFiles();

            try {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(fileBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
