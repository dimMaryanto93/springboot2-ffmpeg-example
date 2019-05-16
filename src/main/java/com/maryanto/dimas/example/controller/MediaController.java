package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.service.FileStoreService;
import com.maryanto.dimas.example.service.FileStoreService.TypeOfMedia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private FileStoreService fileService;

    @PostMapping(
            value = "/upload/video",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_OCTET_STREAM_VALUE}
    )
    public ResponseEntity<?> createVideo(@RequestPart("content") MultipartFile file) {
        try {
            String fileName = fileService.createFile(file, TypeOfMedia.Videos);
            fileService.convertVideo(fileName, "mp4");
            return ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
