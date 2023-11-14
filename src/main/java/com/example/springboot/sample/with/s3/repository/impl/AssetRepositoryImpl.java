package com.example.springboot.sample.with.s3.repository.impl;

import com.example.springboot.sample.with.s3.repository.AssetRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class AssetRepositoryImpl implements AssetRepository {

    public List<String> upload(List<MultipartFile> imageDataList) {
        return List.of("https://1.bp.blogspot.com/-PjZz2WJ1Zj0/VMIvCILIJzI/AAAAAAAAq2w/bmdFdi5l4Z4/s800/fish_neontetra.png");
    }
}
