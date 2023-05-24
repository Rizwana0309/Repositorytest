package net.javaguides.sms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service
public class StudentImpl implements StudentService
{

  private StudentRepository studentRepository;
  
	public StudentImpl(StudentRepository studentRepository) 
	{
	super();
	this.studentRepository = studentRepository;
}
	@Override
	public List<Student> getAllStudents() 
	{
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student saveStudent(Student student)
	{
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public Student getStudentByid(Long id) 
	{
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}
	@Override
	public Student UpdateStudent(Student student)
	{
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public void deteleStudentById(Long id) 
	{
		
		 studentRepository.deleteById(id);
	}
    
}
