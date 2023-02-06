package com.microorder.productservice.productmanager;

import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microorder.productservice.common.MongoDBTestContainer;
import com.microorder.productservice.productmanager.dto.ProductRequest;
import com.microorder.productservice.productmanager.dto.ProductResponse;
import java.util.List;

@SpringBootTest
@Testcontainers
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
class ProductManagerControllerTest
{
    @ClassRule
    public static final MongoDBTestContainer mongoDbTestContainer = MongoDBTestContainer.getInstance();

    @Autowired
    private MockMvc mvc;
    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

    @BeforeAll
    static void startup()
    {
        mongoDbTestContainer.start();
    }

    @Test
    void createProduct_thenStatus200() throws Exception
    {
        final ProductRequest productRequest = createValidProductRequest();
        final String json = ow.writeValueAsString(productRequest);
        mvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void getProduct_thenStatus200() throws Exception
    {
        MvcResult result = mvc.perform(get("/api/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final List<ProductResponse> productResponseList = mapper.readValue(content, new TypeReference<>()
        {
        });

        Assertions.assertEquals(1, productResponseList.size());
    }

    private ProductRequest createValidProductRequest()
    {
        return new ProductRequest("Test name", "Test description", 1.0);
    }
}