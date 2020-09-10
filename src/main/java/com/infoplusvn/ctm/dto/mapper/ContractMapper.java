package com.infoplusvn.ctm.dto.mapper;

import com.infoplusvn.ctm.dto.ContractDto;
import com.infoplusvn.ctm.entity.Contract;
import com.infoplusvn.ctm.util.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {DateUtils.class})
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    @Mapping(source = "createdDt" , target = "createdDt", qualifiedByName = "stringToTimestamp")
    Contract dtoToEntity(ContractDto contractDto);

    @Mapping(source = "createdDt",target = "createdDt", qualifiedByName = "timestampToString")
    ContractDto entityToDto(Contract contract);

    List<ContractDto> entitiesToDtos(List<Contract> contracts);



}
