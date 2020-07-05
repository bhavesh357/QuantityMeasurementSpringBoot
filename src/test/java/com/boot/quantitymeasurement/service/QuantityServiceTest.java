package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.controller.QuantityController;
import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.MainUnit;
import com.boot.quantitymeasurement.model.SubUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class QuantityServiceTest {

    @Autowired
    private MockMvc mockMvc;

    private List<MainUnit> mainUnits;
    private List<SubUnit> subUnits;

    @MockBean
    private QuantityService service;

    @Test
    public void givenNothing_WhenGet_ShouldReturnMainUnitList() throws Exception {
        Mockito.when(service.getMainUnit()).thenReturn(mainUnits);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/").
                accept(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }



}
