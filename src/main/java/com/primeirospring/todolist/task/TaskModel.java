package com.primeirospring.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_tasks")
@Data
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;
    
    @Column(length = 50) //Limitando campo de caracteres
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;
    
    @CreationTimestamp //Pra quando for criada no banco de dados
    private LocalDateTime createdAt;

    //Primerio passo: try catch
    //Segundo passo: passar a responsabilidade de arrumar pra quem tá chamando
    
    public void setTitle(String title) throws Exception{
        if (title.length() > 50){
            //Exception são as exceções mais comuns
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
