package com.menes.services;

import com.menes.models.Student;
import com.menes.models.StudentDTO;
import com.menes.models.StudentDTOMapper;
import com.menes.repositories.StudentRepository;
import com.menes.utilities.EmailValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDTOMapper studentDTOMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentDTOMapper studentDTOMapper) {
        this.studentRepository = studentRepository;
        this.studentDTOMapper = studentDTOMapper;
    }


    public List<StudentDTO> getStudentList() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentDTOMapper)
                .collect(Collectors.toList());
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student doesn't exists with id = " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));
        if (isNameValid(name) && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (EmailValidator.isValidEmail(email)) {
            if (studentRepository.findStudentByEmail(email).isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }


    }

    private boolean isNameValid(String name) {
        return name != null && name.length() > 0;
    }

    public Long getSize() {
        return studentRepository.count();
    }

    public StudentDTO getStudentById(Long studentId) {
        return studentRepository
                .findById(studentId)
                .map(studentDTOMapper)
                .orElseThrow(() -> new IllegalStateException("Can not found Student with id=[%d]".formatted(studentId)));
    }

    public Object getNames(String type) {
        if (type == null) return studentRepository.getNames();
        return type.equalsIgnoreCase("ASC")
                ? studentRepository.getNamesByAsc() : studentRepository.getNamesByDesc();

    }
}
