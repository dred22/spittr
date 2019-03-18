package web.handbook.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import web.handbook.config.RootConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    HomeController controller;

    @Test
    public void testHomePage()
            throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        MockHttpServletRequestBuilder getResult = get("/");
        ResultMatcher expectedView = view().name("home");

        mockMvc.perform(getResult)
                .andExpect(expectedView);
    }
}