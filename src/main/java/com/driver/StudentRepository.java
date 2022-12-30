package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
@Component
public class StudentRepository {
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<Teacher, List<String>> teacherHashMap = new HashMap<>();
    public void AddStudent (Student student){
        studentHashMap.put(student.getName(), student);
    }

    public void AddTeacher(Teacher teacher){
        List<String> list = new ArrayList<>();
        teacherHashMap.put(teacher,list);
    }

    public void AddStudentTeacher(String student, String teacher){
        for (Teacher teacher1:teacherHashMap.keySet()) {
            if (Objects.equals(teacher, teacher1.getName())) {
                List<String> list;
                list = teacherHashMap.get(teacher1);
                list.add(student);
                teacherHashMap.put(teacher1, list);
                return;
            }
        }
    }

    public Student GetStudentName(String name){
        return studentHashMap.get(name);
    }

    public Teacher GetTeacherName(String name){
        for(Teacher teacher:teacherHashMap.keySet()){
            if(Objects.equals(name,teacher.getName())){
                return teacher;
            }
        }
        return null;
    }
    public List<String>GetStudentByTeacherName(String teacher){
        for(Teacher teacher1:teacherHashMap.keySet()){
            if(Objects.equals(teacher,teacher1.getName())){
                return teacherHashMap.get(teacher1);
            }
        }
        return null;
    }
    public List<String> GetAllStudents(){
        return new ArrayList<>(studentHashMap.keySet());
    }
    public void DeletingTeacherByName(String teacher) {
        for (Teacher teacher1 : teacherHashMap.keySet()) {
            if (Objects.equals(teacher, teacher1.getName())) {
                List<String> temp = teacherHashMap.get(teacher1);
                for (String str : temp) {
                    studentHashMap.remove(str);
                }
                teacherHashMap.remove(teacher1);
                return;
            }

        }
    }
    public void DeleteAllTeacher() {
        for (List<String> str : teacherHashMap.values()) {
            for (String str1 : str) {
                studentHashMap.remove(str1);
            }
        }
        teacherHashMap.clear();
    }


}
