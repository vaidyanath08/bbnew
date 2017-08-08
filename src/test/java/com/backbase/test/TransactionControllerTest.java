/**
 * 
 */
package com.backbase.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.backbase.controller.TransactionController;
import com.backbase.controller.Impl.TransactionControllerImpl;
 

/**
 * @author M1040042
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class TransactionControllerTest {
	
	@Autowired
    private TransactionControllerImpl txnController;
	
	/*@Autowired
    private TransactionServiceImpl txnService;
	*/
	@Autowired
    private WebApplicationContext ctx;
 
    private MockMvc mockMvc;
 
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    
    @Test
    public void getTransactionsTest() throws Exception {
        String type  = "sandbox-payment";
        mockMvc.perform(get("/transactions/transactionlist/{type}",type).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("type").value(type));
    }
    
    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {
 
        @Bean
        public TransactionController transactionController() {
            return new TransactionControllerImpl();
        }
 
    }
}
