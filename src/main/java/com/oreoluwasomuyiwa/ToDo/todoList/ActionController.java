package com.oreoluwasomuyiwa.ToDo.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ToDo")
public class ActionController {
    private final ToDoService toDoService;

    @Autowired
    public ActionController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping()
    public List<ToDo> getTasks(){
        return toDoService.getTasks();
    }

    @PostMapping()
    public void addTask(@RequestBody ToDo toDo){
        toDoService.addTask(toDo);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        toDoService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) ToDo toDo){
        toDoService.updateTask(taskId,toDo);

    }
}
