package com.example.springboot.sample.with.s3.repository;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AssetRepository {

    /**
     * 画像アップロード
     *
     * @param imageData 登録する画像データ
     * @return アップロードした画像のパス一覧
     */
    List<String> upload(List<MultipartFile> imageData);
}
