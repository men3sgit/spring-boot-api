package com.menes.services;

import com.menes.utilities.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageStorageService  {
//    private final Path storageFolder = Paths.get("uploads");
//    public ImageStorageService(){
//        try{
//            Files.createDirectories(storageFolder);
//        } catch (IOException e) {
//            throw new RuntimeException("cannot initialize storage", e);
//        }
//    }
//
//    private boolean isImageFile(MultipartFile file) {
//        String fileExtension = FileUtils.getExtension(file.getOriginalFilename());
//        System.out.println(fileExtension);
//        return Arrays.asList("png", "jpg", "jpeg", "bmp")
//                .contains(fileExtension.toLowerCase());
//    }
//
//    @Override
//    public String storeFile(MultipartFile multipartFile) {
//        try {
//            System.out.println("Haha");
//            if (multipartFile.isEmpty()) {
//                throw new RuntimeException("Failed to store empty file.");
//            }
//            if (!isImageFile(multipartFile)) {
//                throw new RuntimeException("you can only upload image file.");
//            }
//
//            final float megabyteUnit = 1_024_000f;
//            float fileSize = multipartFile.getSize() / megabyteUnit;
//
//            if (fileSize >= 5.0f) {
//                throw new RuntimeException("File must be <= 5Mb");
//            }
//
//            String fileExtension = FileUtils.getExtension(Objects.requireNonNull(multipartFile.getOriginalFilename()));
//            String generatedFileName = UUID.randomUUID().toString().replace("-", "");
//            generatedFileName += "." + fileExtension;
//
//            Path destinationFilePath = this.storageFolder.resolve(Paths.get(generatedFileName))
//                    .normalize().toAbsolutePath();
//
//            if (!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
//                throw new RuntimeException("cannot store file outside current directory.");
//            }
//            System.out.println(destinationFilePath);
//            System.out.println(generatedFileName);
//            System.out.println(multipartFile.getInputStream().read());
//            try (InputStream inputStream = multipartFile.getInputStream()) {
//                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
//            }
//            return generatedFileName;
//
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to store file.", e);
//        }
//
//    }
//
//    @Override
//    public Stream<Path> loadAll() {
//        return null;
//    }
//
//    @Override
//    public byte[] readFileContent(String fileName) throws IOException {
//        Path path = Path.of(storageFolder.toAbsolutePath() + "/"+fileName);
//        return Files.readAllBytes(path);
//    }
}
