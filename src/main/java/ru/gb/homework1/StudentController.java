package ru.gb.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentRepository repository;


    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable long id){
        return repository.getById(id);
    } // поиск по id

    @GetMapping(value = "all")
    public List<Student> getAll(){
        return repository.getAll();
    }      // поиск всех http://localhost:8080/students/all

    @GetMapping(value = "search")
    public List<Student> getByName(@RequestParam String name){
        // поиск по подстроке в имени http://localhost:8080/students/search?name='name'
        List <Student> list = new ArrayList<>();
        for (Student student: repository.getAll())
        if(student.getName().contains((name))){
            list.add(student);
        }
        return list;
    }

    @GetMapping(value = "group")

    public List<Student> getByGroup(@RequestParam String groupName){ // поиск по группе http://localhost:8080/students/groupName
        List <Student> list = new ArrayList<>();
        for (Student student: repository.getAll())
            if(student.getGroupName().equals(groupName)){
                list.add(student);
            }
        return list;
    }
}
