package com.oreoluwasomuyiwa.ToDo.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService  {
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getTasks() {
        return toDoRepository.findAll();
    }

    public void addTask(ToDo toDo) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(toDo.getId());
        if(optionalToDo.isPresent()){
            throw new IllegalStateException("Task already exists");
        }
        else {
            toDoRepository.save(toDo);
        }

    }
    public void deleteTask(Long taskId) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(taskId);
        if(optionalToDo.isEmpty()){
            throw new IllegalStateException("No task with Id " + taskId);
        }
        else{
            toDoRepository.deleteById(taskId);
        }
    }
    @Transactional
    public void updateTask(Long taskId, ToDo toDo) {
        Optional<ToDo> optionalToDo = toDoRepository.findToDoByTask(toDo.getTask());
        if(optionalToDo.isEmpty()){
            throw new IllegalStateException("No task with Id " + taskId);
        }
        if(taskId>0 ){
            toDo.setTask(String.valueOf(toDo));
        }

    }
}
