package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController 
{
	private StudentService studentService;

	public StudentController(StudentService studentService) 
	{
		super();
		this.studentService = studentService;
	}

	@GetMapping("/student")
	public String listStudents(Model model)
	{
		model.addAttribute("Students",studentService.getAllStudents());
		return "student";
		
	}
	
	@GetMapping("/student/new")
	public String createnewStudentForm(Model model) 
	{
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/student";
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudentform(@PathVariable Long id,Model model)
	{
	   model.addAttribute("student",studentService.getStudentByid(id));	
		return "edit_student";
	}
	
     @PostMapping("/student/{id}")	
      public String updatestudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model)
     {
    	 Student existingStudent = studentService.getStudentByid(id);
    	 existingStudent.setFirstname(student.getFirstname());
    	 existingStudent.setLastname(student.getLastname());
    	 existingStudent.setEmail(student.getEmail());
    	 
    	 studentService.UpdateStudent(existingStudent);
    	 return "redirect:/student";
     }
     
     @GetMapping("/student/{id}")
     public String deleteStudent(@PathVariable Long id)
     {
    	studentService.deteleStudentById(id);
    	return "redirect:/student";
     }
     
     
         
}



	