package com.caiury.propostaapp.mapper;

import com.caiury.propostaapp.dto.PropostaRequestDto;
import com.caiury.propostaapp.dto.PropostaResponseDto;
import com.caiury.propostaapp.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.sobrenome", source = "sobrenome")
    @Mapping(target = "usuario.cpf", source = "cpf")
    @Mapping(target = "usuario.telefone", source = "telefone")
    @Mapping(target = "usuario.renda", source = "renda")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovado", ignore = true)
    @Mapping(target = "integrada", ignore = true)
    @Mapping(target = "observacao", ignore = true)
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "sobrenome", source = "usuario.sobrenome")
    @Mapping(target = "cpf", source = "usuario.cpf")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "renda", source = "usuario.renda")
    PropostaResponseDto propostaToConvertConvertDto(Proposta proposta);

    List<PropostaResponseDto> propostaListToCovertDto(List<Proposta> propostas);
}
