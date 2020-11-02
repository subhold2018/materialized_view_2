package com.lumendata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.entity.EmailEntity;
import com.lumendata.model.Customer;
import com.lumendata.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Component
@Slf4j
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    List<String> sourceList= Arrays.asList("CS","HR","ADVANCE");

    public void processMessage(String data) {
        String guid=null;
      try{
          ObjectMapper objectMapper=new ObjectMapper();
//          objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
          Customer customer=objectMapper.readValue(data,Customer.class);
          List<EmailEntity> emailEntities=new ArrayList<>();
          guid=customer.getGuid();
          customer.getEmails().forEach(email -> {
              if(!"Y".equalsIgnoreCase(email.getLogicalDeleteFlg())
                      && sourceList.contains(email.getSource())) {
                  EmailEntity customerEntity = new EmailEntity();
                  customerEntity.setPartyUid(customer.getGuid());
                  customerEntity.setSource(email.getSource());
                  customerEntity.setSourceId(email.getSourceId());
                  customerEntity.setEmailType(email.getUseType());
                  customerEntity.setEmail(email.getEmail());
                  emailEntities.add(customerEntity);
              }
          });
          customerRepository.deleteAll(customerRepository.findByPartyUid(guid));
          customerRepository.saveAll(emailEntities);
        }catch (Exception exception){
            log.error("Exception while saving customer data into mv-2==>customer table guid={}",guid,exception);
        }
    }
}
