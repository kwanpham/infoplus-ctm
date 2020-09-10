package com.infoplusvn.ctm.controller.v1.api;

import com.infoplusvn.ctm.controller.v1.api.request.ContractDetailRequest;
import com.infoplusvn.ctm.dto.ContractDetailDto;
import com.infoplusvn.ctm.exception.LogicException;
import com.infoplusvn.ctm.exception.ResourceNotFoundException;
import com.infoplusvn.ctm.repo.ContractDetailRepo;
import com.infoplusvn.ctm.service.ContractDetailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by https://github.com/kwanpham
 */

@RestController
@RequestMapping("/api")
public class ContractDetailController {


    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractDetailRepo contractDetailRepo;

    @ApiOperation(value = "Get all contract detail" ,  authorizations = {@Authorization(value = "apiKey")})
    @GetMapping("/contract-detail")
    public ResponseEntity getAllContractDetail() {
        return  ResponseEntity.ok(contractDetailService.getAllUpcomingSale(PageRequest.of(0,3)));
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @PostMapping("/contract-detail")
    public ResponseEntity addNewContractDetail(@RequestBody ContractDetailRequest cddr) throws ResourceNotFoundException {
        contractDetailService.createNewContractDetail(modelMapper.map(cddr , ContractDetailDto.class));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @PostMapping("/contract-detail/version")
    public ResponseEntity addNewContractDetailVersion(@RequestBody ContractDetailRequest cddr) throws ResourceNotFoundException, LogicException {
        contractDetailService.createNewContractDetailVersion(modelMapper.map(cddr , ContractDetailDto.class));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @GetMapping("/contract-detail/up-comming-sale")
    public ResponseEntity<List<ContractDetailDto>> getAllUpConmmingSale() throws ResourceNotFoundException, LogicException {
        List<ContractDetailDto> result = contractDetailService.getUpCommingContract("S");
        if (result.size() == 0 )
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @GetMapping("/contract-detail/up-comming-purchase")
    public ResponseEntity<List<ContractDetailDto>> getAllUpConmmingPurchase() throws ResourceNotFoundException, LogicException {
        List<ContractDetailDto> result = contractDetailService.getUpCommingContract("P");
        if (result.size() == 0 )
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @DeleteMapping("/contract-detail")
    public ResponseEntity deleteCurrentContractDetail(@RequestParam Long id) throws ResourceNotFoundException, LogicException {
        contractDetailService.removeContractDetail(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    @PutMapping("/contract-detail/revert")
    public ResponseEntity revertCurrentContractDetail(@RequestParam long currentId , @RequestParam long revertId) throws ResourceNotFoundException, LogicException {
        contractDetailService.revertContractDetail(currentId , revertId);
        return ResponseEntity.ok().build();
    }
}
