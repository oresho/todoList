package com.oreoluwasomuyiwa.ToDo.todoList;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity(name = "ToDo")
@Table(name = "ToDo")
public class ToDo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence")
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Column(
            name = "id",
            updatable = false
    )
    private long id;
    @NotBlank(message = "Task is empty")
    @Column(
            name = "task",
            unique = true,
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String task;

    //@NotBlank(message = "Date is empty")
    @Column(name = "dateAdded",
            columnDefinition = "date",
            updatable = false)
    private LocalDate dateAdded;

    @Column(name = "dateCompleted",
            columnDefinition = "date")
    private LocalDate dateCompleted;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public ToDo() {
    }

    public ToDo(long id, String task, LocalDate dateAdded, LocalDate dateCompleted) {
        this.id = id;
        this.task = task;
        this.dateAdded = dateAdded;
        this.dateCompleted = dateCompleted;
    }

    public ToDo(String task, LocalDate dateAdded, LocalDate dateCompleted) {
        this.task = task;
        this.dateAdded = dateAdded;
        this.dateCompleted = dateCompleted;
    }

    public ToDo(String task, LocalDate dateAdded) {
        this.task = task;
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", dateAdded=" + dateAdded +
                ", dateCompleted=" + dateCompleted +
                '}';
    }
}
