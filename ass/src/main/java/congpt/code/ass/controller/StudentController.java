package congpt.code.ass.controller;


import congpt.code.ass.entity.Student;
import congpt.code.ass.repository.StudentRepository;
import congpt.code.ass.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("scores", studentScoreRepository.findAll()); // Thêm dòng này
        return "student_list";
    }

    @GetMapping("/students/new")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }
}
