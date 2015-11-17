package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */
import com.travelo.entities.ImageEntity;
import com.travelo.services.ImageService;
import com.travelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


@Controller
@RequestMapping("/images")
public class UploadController
{
    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageEntity imageEntity;

    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;

        while(itr.hasNext()){

            mpf = request.getFile(itr.next());
            imageEntity.setImagePath("//resources//img//userImages//" + mpf.getOriginalFilename());
            imageEntity.setNote("");
            fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
                fileMeta.setBytes(mpf.getBytes());
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("C:/Users/ddph/Desktop/podr/Travalo/src/main/webapp/resources/img/userImages/" + mpf.getOriginalFilename()));
                imageService.addImage(imageEntity);

            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(fileMeta);
        }
        return files;

    }
}
