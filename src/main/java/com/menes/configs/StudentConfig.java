package com.menes.configs;

import com.menes.models.PhotoDetails;
import com.menes.models.Student;
import com.menes.repositories.PhotoRepository;
import com.menes.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository, PhotoRepository photoRepository
            ) {
        return args -> {
            //    public Student(Long id, String name, String email, LocalDate dob, Integer age) {
            Student menes = new Student(
                    "Menes",
                    "contact@menes.com",
                    LocalDate.of(2001, 10, 2
                    ));
            Student ling = new Student(
                    "Tuling",
                    "contact@tuling.com",
                    LocalDate.of(2002, 10, 27)
            );

            PhotoDetails p1 = new PhotoDetails(
                    "images/nature/nature-1.jpg",
                    "A bus",
                    "Film"
            );
            PhotoDetails p2 = new PhotoDetails(
                    "images/nature/nature-1.jpg",
                    "Quiet Space",
                    "Film"
            );

            photoRepository.saveAll(List.of(p1,p2));
            studentRepository.saveAll(List.of(menes, ling));

        };
    }
}
