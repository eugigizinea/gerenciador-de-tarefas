package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "Tarefas")
public class TarefaEntity {
    public String nome;
    @Id
    public  UUID id;
    public  Date criadoEm;
    public  Date atualizadoEm;
    public  Date dataInicio;
    public  Date dataFim;
    public String descricao;
    public String responsavel;
}
