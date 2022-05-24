package com.oreoluwasomuyiwa.ToDo.todoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ToDoConfig {

    @Bean
    CommandLineRunner commandLineRunner(ToDoRepository toDoRepository){
        return args -> {
            ToDo task1 = new ToDo("Wake up", LocalDate.now());
            ToDo task2 = new ToDo("Have Bath",LocalDate.now());
            toDoRepository.saveAll(
                    List.of(task1,task2));
        };

    }
}
