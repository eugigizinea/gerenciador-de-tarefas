package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.TarefaDTO;
import org.example.entity.TarefaEntity;
import org.example.request.AtualizarTarefaRequest;
import org.example.request.RegistrarTarefaRequest;
import org.example.response.AtualizarTarefaResponse;
import org.example.response.ConsultarTarefaIDResponse;
import org.example.response.ConsultarTarefaResponse;
import org.example.response.RegistrarTarefaResponse;
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
    public RegistrarTarefaResponse registrarAtividade (@RequestBody RegistrarTarefaRequest request){
    return tarefaService.save(request.toDto());
    }
    @GetMapping
    public List<ConsultarTarefaResponse> consultar (){
        return tarefaService.consultar();
    }
    @GetMapping("{id}")
    public ConsultarTarefaIDResponse consultar (@PathVariable UUID id){
        return tarefaService.consultar(id);
    }
    @PatchMapping("{id}")
    public void atualizar(@PathVariable UUID id,
                                             @RequestBody AtualizarTarefaRequest request){
        tarefaService.atualizar(id, request.toDto());}


}
