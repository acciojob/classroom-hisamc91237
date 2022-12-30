package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void AddStudent(Student student){
        studentRepository.AddStudent(student);
    }

    public void AddTeacher(Teacher teacher){
        studentRepository.AddTeacher(teacher);
    }
    public void AddStudentTeacher(String student, String teacher){
        studentRepository.AddStudentTeacher(student, teacher);

    }
    public Student GetStudentName(String name) {
        return studentRepository.GetStudentName(name);
    }
    public Teacher GetTeacherName(String name){
        return studentRepository.GetTeacherName(name);
    }
    public List<String>GetStudentByTeacherName(String teacher){
        return studentRepository.GetStudentByTeacherName(teacher);
    }
    public  List<String>GetAllStudent(){
        return studentRepository.GetAllStudents();
    }
    public void DeletingTeacherByName(String teacher){
        studentRepository.DeletingTeacherByName(teacher);
    }
    public void DeleteAllTeacher(){
        studentRepository.DeleteAllTeacher();
    }


}
