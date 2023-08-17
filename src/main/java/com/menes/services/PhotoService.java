package com.menes.services;

import com.menes.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.menes.models.PhotoDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PhotoService implements IStorageService {
    private final PhotoRepository photoRepository;
    private final Path storageFolder = Paths.get("src/main/resources/templates/images/");

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<PhotoDetails> getAllPhotos() {
        return photoRepository.findAll();
    }

    @Override
    public String storeFile(MultipartFile multipartFile)  {

        try {
            Path destinationFilePath = this.storageFolder.resolve(Paths.get(Objects.requireNonNull(multipartFile.getOriginalFilename())))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = multipartFile.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
                photoRepository.save(new PhotoDetails("images/"+multipartFile.getOriginalFilename(),
                        "abcd","Book"));
            }

            return multipartFile.getOriginalFilename();

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public byte[] readFileContent(String fileName) throws IOException {
        return new byte[0];
    }
}
