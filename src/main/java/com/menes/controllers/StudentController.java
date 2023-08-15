package com.menes.controllers;

import com.menes.models.Student;
import com.menes.models.StudentDTO;
import com.menes.services.StudentService;
import com.menes.utilities.MyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(path = "{studentId}")
    public StudentDTO getStudent(
            @PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }
    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getStudentList();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
    @GetMapping(path = "/size")
    public Long getSize(){
        return studentService.getSize();
    }
    @GetMapping(path = "/names")
    public MyResponse getNames(@RequestParam(required = false) String type){
        return new MyResponse(200,"success",
                studentService.getNames(type));
    }
}
