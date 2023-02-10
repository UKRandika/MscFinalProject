package com.example.demo.Servises;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public interface FileService {

    void store(String path,
               String fileName,
               Optional<Map<String, String>> optionalMetaData,
               InputStream inputStream);
}
