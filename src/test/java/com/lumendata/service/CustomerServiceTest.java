package com.lumendata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.Customer;
import com.lumendata.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void shouldSaveEmailMessage() throws IOException {
        customerService.processMessage(getTestData());
        Mockito.verify(customerRepository,Mockito.times(1))
                .findByPartyUid(Mockito.anyString());
        Mockito.verify(customerRepository,Mockito.times(1))
                .deleteAll(Mockito.any());
        Mockito.verify(customerRepository,Mockito.times(1))
                .saveAll(Mockito.any());
    }

    private String getTestData() {
        return "{\n" +
                "   \"guid\":\"guid-1299888\",\n" +
                "  \"emails\":[\n" +
                "      {\n" +
                "       \"email\" :\"jeethome2-update@gmail.com\",\n" +
                "       \"logicalDeleteFlg\": \"Y\",\n" +
                "        \"useType\":\"Home2\",\n" +
                "       \"sourceId\":\"9976544\",\n" +
                "       \"source\": \"CS\"\n" +
                "      },\n" +
                "       {\n" +
                "       \"email\" :\"jeetOffice@lumendata.com\",\n" +
                "       \"logicalDeleteFlg\": \"N\",\n" +
                "        \"useType\":\"Office\",\n" +
                "       \"sourceId\":\"9976548\",\n" +
                "       \"source\": \"HR\"\n" +
                "      }\n" +
                "  ]\n" +
                "}";
    }

}
