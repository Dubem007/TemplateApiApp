package com.example.Template_Api.student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository _studentRepository;

    public StudentService(StudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return _studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentOptional = _studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("The email already taken");
        }
        _studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exist = _studentRepository.existsById(id);

        if(!exist)
        {
            throw new IllegalArgumentException("Student does not exist");
        }
        _studentRepository.deleteById(id);
    }


    public void updateStudent(Long id, String name, String email){
        Student student = _studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("The student with Id " + id + " does not exist"));

        if(email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email))
        {
            Optional<Student> studentOptional = _studentRepository.findStudentByEmail(student.getEmail());
            if(!studentOptional.isPresent()){
                throw new IllegalStateException("The email not exist");
            }
            student.setEmail(email);
        }

        if(name != null && !name.isEmpty() && !Objects.equals(student.getName(), name))
        {
            student.setEmail(name);
        }
    }
}
