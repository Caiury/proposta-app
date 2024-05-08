package com.caiury.propostaapp.controller;

import com.caiury.propostaapp.dto.PropostaRequestDto;
import com.caiury.propostaapp.dto.PropostaResponseDto;
import com.caiury.propostaapp.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaService service;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaRequestDto requestDto) {

        PropostaResponseDto response = service.criar(requestDto);
        return ResponseEntity.ok(response);
    }
}
