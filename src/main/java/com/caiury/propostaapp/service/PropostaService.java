package com.caiury.propostaapp.service;

import com.caiury.propostaapp.dto.PropostaRequestDto;
import com.caiury.propostaapp.dto.PropostaResponseDto;
import com.caiury.propostaapp.entity.Proposta;
import com.caiury.propostaapp.mapper.PropostaMapper;
import com.caiury.propostaapp.mapper.PropostaMapperImpl;
import com.caiury.propostaapp.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    @Transactional
    public PropostaResponseDto criar(PropostaRequestDto requestDto) {

        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);

        repository.save(proposta);

        return PropostaMapper.INSTANCE.propostaToConvertConvertDto(proposta);
    }

    public List<PropostaResponseDto> buscarTodas() {

        return PropostaMapper.INSTANCE.propostaListToCovertDto(repository.findAll());
    }
}
