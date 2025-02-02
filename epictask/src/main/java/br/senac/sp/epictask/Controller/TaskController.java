package br.senac.sp.epictask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.sp.epictask.model.Task;
import br.senac.sp.epictask.repository.TaskRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("task")

public class TaskController {
    @Autowired

    TaskRepository repository;

    @GetMapping

    public String index(Model model) {

        var lista = repository.findAll();
        model.addAttribute("tasks", lista);
                System.out.println(lista);
        return "task/index";

    }
    @GetMapping("new")
    public String form(Task task){
        return "task/form";
    }

    @PostMapping("new")
    public String save(@Valid Task task, BindingResult result){
        if(result.hasErrors())
        return "task/form";
        
        repository.save(task);
        return "redirect:/task";

    }
}