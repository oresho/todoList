package com.oreoluwasomuyiwa.ToDo.todoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    @Query("SELECT t FROM ToDo t WHERE t.task = ?1")
    Optional<ToDo> findToDoByTask(String task);
}
