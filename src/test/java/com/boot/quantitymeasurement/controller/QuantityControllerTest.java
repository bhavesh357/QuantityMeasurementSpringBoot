package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;
import com.boot.quantitymeasurement.service.QuantityService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class QuantityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private List<Unit.MainUnit> mainUnits;
    private List<Unit.SubUnit> subUnits;

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

    @Test
    void givenMainUnit_WhenGet_ShouldReturnSubUnitList() throws Exception {
        Mockito.when(service.getSubUnit(Mockito.any(Unit.MainUnit.class))).thenReturn(subUnits);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(Unit.MainUnit.LENGTH)).
                contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void givenQuantity_WhenGet_ShouldReturnConvertedQuantity() throws Exception {
        Quantity quantity= new Quantity(Unit.MainUnit.LENGTH,Unit.SubUnit.FEET,1,Unit.SubUnit.INCH,0);
        Mockito.when(service.getConvertedQuantity(quantity)).
                thenReturn(quantity);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(quantity)).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    public void givenImproperQuantity_WhenMainUnit_ShouldReturnConvertedQuantity() throws Exception{
        Quantity quantity = new Quantity(Unit.MainUnit.Hair, Unit.SubUnit.GALLON, 1, Unit.SubUnit.LITRE, 0);
        Mockito.when(service.getConvertedQuantity(Mockito.any())).thenThrow(new QuantityException(400,"Enter proper main unit"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(quantity)).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals("{\"code\":400,\"message\":\"Enter proper main unit\",\"object\":null}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void givenImproperQuantity_WhenSubUnit_ShouldReturnConvertedQuantity() throws Exception{
        Quantity quantity = new Quantity(Unit.MainUnit.Hair, Unit.SubUnit.GALLON, 1, Unit.SubUnit.LITRE, 0);
        Mockito.when(service.getConvertedQuantity(Mockito.any())).thenThrow(new QuantityException(400,"Enter proper sub unit"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(quantity)).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals("{\"code\":400,\"message\":\"Enter proper sub unit\",\"object\":null}",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void givenMainUnit_WhenImproper_ShouldReturnNull() throws Exception {
        Mockito.when(service.getSubUnit(Mockito.any())).thenThrow(new QuantityException(400,"Enter proper main unit"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/unit").
                accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(Unit.MainUnit.Hair)).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assert.assertEquals("{\"code\":400,\"message\":\"Enter proper main unit\",\"object\":null}",mvcResult.getResponse().getContentAsString());
    }

}
