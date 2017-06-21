package newDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by student on 6/21/17.
 */
@Controller
public class StudentController {

    @Autowired
     StudentRepository studentRepository;

    @RequestMapping(value="/uniform", method = RequestMethod.GET)
    public String forfood(Model model){
        model.addAttribute(new Student());
        System.out.println("GET");
        return "uniform";
    }

    @RequestMapping(value="/uniform", method = RequestMethod.POST)
    public String forfoodPost(@ModelAttribute Student student){
        //model.addAttribute(student);
        studentRepository.save(student);
        System.out.println("POST");
        //studentRepository.findAll();
        return "redirect:/result";
    }
    @GetMapping(path = "/result")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
