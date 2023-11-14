package com.example.springboot.sample.with.s3.converter;

import com.example.springboot.sample.with.s3.exception.InternalServerErrorException;
import com.example.springboot.sample.with.s3.util.DateUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class MultipartFileToFileConverter {

    private static final String BASE_PATH = "/tmp/";

    public File convert(MultipartFile multipartFile) {
        final var path = BASE_PATH + DateUtil.getCurrentDateTime() + multipartFile.getOriginalFilename();
        final var file = new File(path);
        try (FileOutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException e) {
            throw new InternalServerErrorException("リクエストされたファイルの書き込みに失敗しました。", e);
        }

        return file;
    }
}
