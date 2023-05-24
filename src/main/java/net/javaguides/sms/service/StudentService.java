package net.javaguides.sms.service;

import java.util.List;
import net.javaguides.sms.entity.Student;

public interface StudentService 
{
   List<Student> getAllStudents();
   
   Student saveStudent(Student student);
   
   Student getStudentByid(Long id);
   Student UpdateStudent(Student student);
   
   void deteleStudentById(Long id);
}
