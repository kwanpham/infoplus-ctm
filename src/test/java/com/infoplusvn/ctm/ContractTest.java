package com.infoplusvn.ctm;

import com.infoplusvn.ctm.service.ContractDetailService;
import com.infoplusvn.ctm.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



@SpringBootTest
public class ContractTest {


    @Autowired
    ContractDetailService contractDetailService;

    @Test
    public void testSelectContract() {

        Pageable pageable = PageRequest.of(0,3);
        System.out.println(contractDetailService.getAllUpcomingSale(pageable));
    }

    @Test
    public void testUtil() {

        DateUtils.convertStringToTimestamp("2019-11-18 10:54:20");
    }

}
