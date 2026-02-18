package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.TarefaDTO;
import org.example.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

@RestController
@RequestMapping ("api/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public void registrarAtividade ( @RequestBody TarefaDTO request){
    tarefaService.save(request);
    }
}
