package com.pharmacy.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.jsonpath.JsonPath;
import com.pharmacy.ManagmentPharmacyApplication;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ManagmentPharmacyApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllProductsTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int length = JsonPath.parse(content).read("$.length()");

        assertThat(length).isEqualTo(4);
    }

    @Test
    public void getOneProductTest() throws Exception {
        testGetOneProduct(1L, "Visionix");
        testGetOneProduct(2L, "MuscleRelief");
        testGetOneProduct(3L, "NosePro");
    }

    @Test
    public void productNotFoundTest() throws Exception {
        testProductNotFound(10L);
        testProductNotFound(11L);
        testProductNotFound(12L);
    }







    //---------------------------------------------------- Parameterized calls ----------------------------------------------------

    public void testGetOneProduct(Long id, String productName) throws Exception {
        mockMvc.perform(get("/products/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(productName)));
    }

    public void testProductNotFound (Long id) throws Exception {
        mockMvc.perform(get("/products/{id}", id))
                .andExpect(status().is(404))
                .andDo(print());
    }


}



    //addProduct

    //findProduct

    //updateProduct

    //deleteProduct
