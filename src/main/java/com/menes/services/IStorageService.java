package com.menes.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface IStorageService {
    public String storeFile(MultipartFile multipartFile);
    public Stream<Path> loadAll();

    public byte[] readFileContent(String fileName) throws IOException;
}
