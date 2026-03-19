package org.example.service;

import org.example.dto.TarefaDTO;
import org.example.entity.TarefaEntity;
import org.example.repository.TarefaRepository;
import org.example.response.AtualizarTarefaResponse;
import org.example.response.ConsultarTarefaIDResponse;
import org.example.response.ConsultarTarefaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {
    @Mock
    TarefaRepository tarefaRepository;
    @InjectMocks
    TarefaService tarefaService;
    @Test
    void teste_save (){

        // Given
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.responsavel = "giovanna";
        tarefaDTO.dataFim = new Date();
        tarefaDTO.dataInicio = new Date();
        tarefaDTO.nome = "teste";
        tarefaDTO.descricao = "teste2";

        // When
        tarefaService.save(tarefaDTO);

        // Then
        verify(tarefaRepository,times(1)).save(any(TarefaEntity.class));

    }
    @Test
    void teste_consultar_todos (){

        // Given
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.responsavel = "giovanna";
        tarefaDTO.dataFim = new Date();
        tarefaDTO.dataInicio = new Date();
        tarefaDTO.nome = "teste";
        tarefaDTO.descricao = "teste2";

        when(tarefaRepository.findAll()).thenReturn(List.of(tarefaDTO.toEntity(), tarefaDTO.toEntity()));

        // When
        List <ConsultarTarefaResponse> result = tarefaService.consultar();

        // Then
        verify(tarefaRepository,times(1)).findAll();
        assertEquals(2,result.size());
    }
    @Test
    void teste_consultar_um (){

        // Given
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.responsavel = "giovanna";
        tarefaDTO.dataFim = new Date();
        tarefaDTO.dataInicio = new Date();
        tarefaDTO.nome = "teste";
        tarefaDTO.descricao = "teste2";
        UUID id = UUID.randomUUID();

        when(tarefaRepository.findById(any(UUID.class))).thenReturn(Optional.of(tarefaDTO.toEntity()));

        // When
       ConsultarTarefaIDResponse result = tarefaService.consultar(id);

        // Then
        verify(tarefaRepository,times(1)).findById(any(UUID.class));
    }
    @Test
    void teste_atualizar(){

        // Given
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.responsavel = "giovanna";
        tarefaDTO.dataFim = new Date();
        tarefaDTO.dataInicio = new Date();
        tarefaDTO.nome = "teste";
        tarefaDTO.descricao = "teste2";
        UUID id = UUID.randomUUID();

        when(tarefaRepository.findById(any(UUID.class))).thenReturn(Optional.of(tarefaDTO.toEntity()));

        // When
        tarefaService.atualizar( id, tarefaDTO);

        // Then
        verify(tarefaRepository,times(1)).findById(any(UUID.class));
        verify(tarefaRepository,times(1)).save(any(TarefaEntity.class));
    }
}