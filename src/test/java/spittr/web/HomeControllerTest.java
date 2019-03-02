package spittr.web;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {
    @Test
    @Ignore
    public void testHomePage()
            throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        MockHttpServletRequestBuilder getResult = get("/");
        ResultMatcher expectedView = view().name("home");

        mockMvc.perform(getResult)
                .andExpect(expectedView);
    }

/*    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        SpittleController controller = new SpittleController(mockRepository);

        when(mockRepository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spittles/12345"))
        .andExpect(view().name("spittle"))
        .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }*/
}