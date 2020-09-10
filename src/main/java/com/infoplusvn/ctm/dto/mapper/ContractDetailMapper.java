package com.infoplusvn.ctm.dto.mapper;

import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.dto.ContractDetailDto;
import com.infoplusvn.ctm.util.DateUtils;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {DateUtils.class} )
public interface ContractDetailMapper {

    ContractDetailMapper INSTANCE = Mappers.getMapper(ContractDetailMapper.class);



    @Mapping(source = "paymentDt" , target = "paymentDt", qualifiedByName = "stringToTimestamp")
    @Mapping(source = "contractDt" , target = "contractDt", qualifiedByName = "stringToTimestamp")
    @Mapping(source = "paymentInvoiceDt" , target = "paymentInvoiceDt", qualifiedByName = "stringToTimestamp")
    @Mapping(source = "modifiedDt" , target = "modifiedDt", qualifiedByName = "stringToTimestamp" ,ignore = true )
    @Mapping(source = "createdDt",target = "createdDt", qualifiedByName = "timestampToString" , ignore = true)
    ContractDetail dtoToEntity(ContractDetailDto dto);


    @Mapping(source = "paymentDt" , target = "paymentDt", qualifiedByName = "timestampToString")
    @Mapping(source = "contractDt" , target = "contractDt", qualifiedByName = "timestampToString")
    @Mapping(source = "paymentInvoiceDt" , target = "paymentInvoiceDt", qualifiedByName = "timestampToString")
    @Mapping(source = "modifiedDt" , target = "modifiedDt", qualifiedByName = "timestampToString" , ignore = true)
    @Mapping(source = "createdDt",target = "createdDt", qualifiedByName = "timestampToString" , ignore = true)
    ContractDetailDto entityToDto(ContractDetail contractDetail);

    List<ContractDetailDto> entitiesToDtos(List<ContractDetail> contracts);





}
