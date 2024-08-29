package com.example.Template_Api.student;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService _studentService;

    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    @GetMapping("/get")
    public List<Student> getAllStudents()
    {
        return _studentService.getStudent();
    }

    @PostMapping("")
    public void registerNewStudent( @RequestBody Student student)
    {
        _studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent( @PathVariable Long id)
    {
        _studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id,@RequestParam String name, @RequestParam String email)
    {
        _studentService.updateStudent(id, name, email);
    }
}
