package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.TarefaDTO;
import org.example.entity.TarefaEntity;
import org.example.repository.TarefaRepository;
import org.example.request.AtualizarTarefaRequest;
import org.example.request.RegistrarTarefaRequest;
import org.example.response.AtualizarTarefaResponse;
import org.example.response.ConsultarTarefaIDResponse;
import org.example.response.ConsultarTarefaResponse;
import org.example.response.RegistrarTarefaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    public RegistrarTarefaResponse save(TarefaDTO dto){
        TarefaEntity tarefaEntity = dto.toEntity();
     tarefaRepository.save(tarefaEntity);
        RegistrarTarefaResponse registrarTarefaResponse = new RegistrarTarefaResponse();
        registrarTarefaResponse.id = tarefaEntity.id;
        return registrarTarefaResponse;
    }
    public List<ConsultarTarefaResponse> consultar() {
    List <TarefaEntity> tarefas = tarefaRepository.findAll();
    return tarefas.stream().map(tarefaEntity -> {
        ConsultarTarefaResponse consultarTarefaResponse = new ConsultarTarefaResponse();
        consultarTarefaResponse.dataFim = tarefaEntity.dataFim;
        consultarTarefaResponse.descricao = tarefaEntity.descricao;
        consultarTarefaResponse.id = tarefaEntity.id;
        consultarTarefaResponse.responsavel = tarefaEntity.responsavel;
        consultarTarefaResponse.dataInicio = tarefaEntity.dataInicio;
        consultarTarefaResponse.nome = tarefaEntity.nome;
        return consultarTarefaResponse;
    }).collect(Collectors.toUnmodifiableList());
    }
    public ConsultarTarefaIDResponse consultar(UUID id){


        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        ConsultarTarefaIDResponse consultarTarefaIDResponse = new ConsultarTarefaIDResponse();
        consultarTarefaIDResponse.responsavel = tarefaEntity.responsavel;
        consultarTarefaIDResponse.dataFim = tarefaEntity.dataFim;
        consultarTarefaIDResponse.dataInicio = tarefaEntity.dataInicio;
        consultarTarefaIDResponse.descricao = tarefaEntity.descricao;
        consultarTarefaIDResponse.nome = tarefaEntity.nome;
        return consultarTarefaIDResponse;
    }
    public void atualizar (UUID id, TarefaDTO request) {
        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        tarefaEntity.responsavel = request.responsavel;
        tarefaEntity.dataFim = request.dataFim;
        tarefaEntity.dataInicio = request.dataInicio;
        tarefaEntity.descricao = request.descricao;
        tarefaEntity.nome = request.nome;
        tarefaRepository.save(tarefaEntity);
    }
}
