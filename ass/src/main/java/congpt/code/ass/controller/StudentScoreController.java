package congpt.code.ass.controller;


import congpt.code.ass.entity.Student;
import congpt.code.ass.entity.StudentScore;
import congpt.code.ass.entity.Subject;
import congpt.code.ass.repository.StudentRepository;
import congpt.code.ass.repository.StudentScoreRepository;
import congpt.code.ass.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentScoreController {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/scores/new")
    public String showAddScoreForm(Model model) {
        model.addAttribute("studentScore", new StudentScore());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "add_score";
    }

    @PostMapping("/scores")
    public String addScore(@ModelAttribute("studentScore") StudentScore studentScore) {
        Student student = studentRepository.findById(studentScore.getStudent().getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + studentScore.getStudent().getStudentId()));
        Subject subject = subjectRepository.findById(studentScore.getSubject().getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID: " + studentScore.getSubject().getSubjectId()));

        studentScore.setStudent(student);
        studentScore.setSubject(subject);

        studentScoreRepository.save(studentScore);
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên
    }
}
