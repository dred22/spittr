package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import spittr.data.models.Spitter;
import spittr.services.SpitterService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration()
            throws Exception {
        SpitterService mockRepository = Mockito.mock(SpitterService.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");

        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                                .param("firstName", "Jack")
                                .param("lastName", "Bauer")
                                .param("username", "jbauer")
                                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);

    }

    @Test
    public void shouldShowRegistration()
            throws Exception {
        SpitterController controller = new SpitterController(null);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

}