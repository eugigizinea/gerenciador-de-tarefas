package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Tarefa {
    Date dataInicio;
    Date dataFim;
    String descricao;
    String responsavel;

}
