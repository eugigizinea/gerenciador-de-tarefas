package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.TarefaDTO;
import org.example.entity.TarefaEntity;
import org.example.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("api/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public void registrarAtividade ( @RequestBody TarefaDTO request){
    tarefaService.save(request);
    }
    @GetMapping
    public List<TarefaEntity> consultar (){
        return tarefaService.consultar();
    }
    @GetMapping("{id}")
    public TarefaEntity consultar (@PathVariable UUID id){
        return tarefaService.consultar(id);
    }
    @PatchMapping("{id}")
    public TarefaEntity atualizar(@PathVariable UUID id,
                                  @RequestBody TarefaDTO request){
        return tarefaService.atualizar(id, request);}


}
