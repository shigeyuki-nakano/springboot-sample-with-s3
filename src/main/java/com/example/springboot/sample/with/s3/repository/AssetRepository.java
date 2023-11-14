package com.example.springboot.sample.with.s3.repository;

import java.io.File;

public interface AssetRepository {

    /**
     * アップロード
     *
     * @param file 登録するファイル
     * @return アップロードしたファイルのパス
     */
    String upload(File file);

    /**
     * 指定されたURLのファイルを削除する
     *
     * @param url 削除するファイルのURL
     */
    void delete(String url);
}
