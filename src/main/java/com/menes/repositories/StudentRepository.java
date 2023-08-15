package com.menes.repositories;

import com.menes.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    public Optional<Student> findStudentByEmail(String email);

    @Query(
            "SELECT name FROM Student" +
                    " ORDER BY name DESC")
    public Optional<List<String>> getNamesByDesc();
    @Query(
            "SELECT name FROM Student" +
                    " ORDER BY name ASC")
    public Optional<List<String>> getNamesByAsc();
    @Query(
            "SELECT name FROM Student")
    public List<String> getNames();


}
