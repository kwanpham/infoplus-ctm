package com.infoplusvn.ctm;

import com.infoplusvn.ctm.constant.SystemConstant;
import com.infoplusvn.ctm.entity.Contract;
import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.entity.Role;
import com.infoplusvn.ctm.entity.User;
import com.infoplusvn.ctm.repo.ContractDetailRepo;
import com.infoplusvn.ctm.repo.ContractRepo;
import com.infoplusvn.ctm.repo.RoleRepo;
import com.infoplusvn.ctm.repo.UserRepo;
import com.infoplusvn.ctm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class ContractMangermentApplication implements CommandLineRunner {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ContractRepo contractRepo;

    @Autowired
    ContractDetailRepo contractDetailRepo;




    public static void main(String[] args) {
        SpringApplication.run(ContractMangermentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//            Role role = new Role();
//
//            role.setName("employee");
//            roleRepo.saveAndFlush(role);
//
//
//            role.setName("admin");
//            roleRepo.save(role);
//
//
//
//            User user1 = new User()
//                    .setUsername("quanph")
//                    .setEmail("quanph@info.com")
//                    .setPassword(bCryptPasswordEncoder.encode("12345")) //12345
//                    .setRoleList(new HashSet<>(Arrays.asList(role)))
//                    .setStatus(SystemConstant.ACTIVE_STATUS);
//
//            userRepo.save(user1);

//            Contract contract = new Contract();
//            contract.setName("NHBANK");
//
//            contractRepo.save(contract);
//
//
//            Contract contract2 = new Contract();
//            contract2.setName("Woori");
//
//            contractRepo.save(contract2);

//            ContractDetail cd = new ContractDetail();
//            cd.setCompanyName("NH BANK");
//            cd.setRecordSts(1);
//            cd.setVersion(1);
//            cd.setContractDt(new Timestamp(System.currentTimeMillis()));
//            cd.setContractAmount("5000000");
//            cd.setContractTerm("term");
//            cd.setPaymentDt(new Timestamp(System.currentTimeMillis()));
//            cd.setPaymentInvoiceDt(new Timestamp(System.currentTimeMillis()));
//            cd.setPaymentRatio("50%");
//            cd.setPaymentRemain("500000");
//            cd.setPaymentValue("600000");
//            cd.setRootContractDetail(cd);
//
//            contract.setId(1L);
//            cd.setContract(contract);
//
//
//            //cd.setRootContractDetail(cd);
//
//            contractDetailRepo.save(cd);

    }
}
