package org.example.service;

import org.example.dto.TarefaDTO;
import org.example.entity.TarefaEntity;
import org.example.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    public void save(TarefaDTO dto){
        TarefaEntity tarefaEntity = dto.toEntity();
    tarefaRepository.save(tarefaEntity);
    }
    public List<TarefaEntity> consultar() {
    return tarefaRepository.findAll();
    }
    public TarefaEntity consultar(UUID id){
        return tarefaRepository.findById(id).get();
    }
    public TarefaEntity atualizar (UUID id, TarefaDTO request) {
        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        tarefaEntity.responsavel = request.responsavel;
        tarefaEntity.dataFim = request.dataFim;
        tarefaEntity.dataInicio = request.dataInicio;
        tarefaEntity.descricao = request.descricao;
        tarefaRepository.save(tarefaEntity);
        return tarefaEntity;

    }
}
