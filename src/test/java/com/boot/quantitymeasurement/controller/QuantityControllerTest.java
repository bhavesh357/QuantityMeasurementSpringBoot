package com.boot.quantitymeasurement.controller;


import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.MainUnit;
import com.boot.quantitymeasurement.model.SubUnit;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class QuantityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private List<MainUnit> mainUnits;
    private List<SubUnit> subUnits;

    @MockBean
    private QuantityController controller;

    @Test
    public void givenNothing_WhenGet_ShouldReturnMainUnitList() throws Exception {
        Mockito.when(controller.getMainUnit()).thenReturn(mainUnits);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/").
                accept(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void givenMainUnit_WhenGet_ShouldReturnSubUnitList() throws Exception {
        MainUnitDto mainUnitDto = new MainUnitDto();
        mainUnitDto.setUnit(Unit.MainUnit.Length);
        Mockito.when(controller.getSubUnit(Mockito.any(MainUnitDto.class))).thenReturn(subUnits);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(mainUnitDto)).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }
}
