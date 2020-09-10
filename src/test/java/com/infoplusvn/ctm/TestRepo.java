package com.infoplusvn.ctm;

import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.entity.User;
import com.infoplusvn.ctm.repo.ContractDetailRepo;
import com.infoplusvn.ctm.repo.UserRepo;
import com.infoplusvn.ctm.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by https://github.com/kwanpham
 */
@SpringBootTest
public class TestRepo {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ContractDetailRepo contractDetailRepo;

    @Test
    public void testUserRepo() {
        User user = new User()
                .setEmail("quan2@gmail.com")
                .setPassword(bCryptPasswordEncoder.encode("12345"))
                .setUsername("");
        System.out.println(bCryptPasswordEncoder.encode("12345"));
    }

    @Test
    public void testContractDetailRepo() {
        Timestamp t1 = DateUtils.convertStringToTimestamp("2019-11-18 10:47:55");
        Timestamp t2 = DateUtils.convertStringToTimestamp("2019-11-25 10:47:55");

        List<ContractDetail> contractDetails = contractDetailRepo.findUpcommingContractDetail(t1 ,t2,"S" ,1 , null);
     }
}
