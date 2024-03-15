package ru.gb.homework1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("newBeanName")
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
//@Primary
public class StudentRepository {
    private final List<Student> list;

    public StudentRepository() {
        list = new ArrayList<>();
        list.add(new Student("Костя","111"));
        list.add(new Student("Иван","112"));
        list.add(new Student("Семен","113"));
        list.add(new Student("Кирилл","113A"));
        list.add(new Student("Василий", "114"));
        list.add(new Student("Петр", "111"));
    }

    public Student getById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAll(){
        return List.copyOf(list);
    }

    public Student getByName(String name){
        return list.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    public Student getByGroup(String groupName){
        return list.stream()
                .filter(e -> e.getGroupName().equals(groupName))
                .findFirst()
                .orElse(null);
    }
}
