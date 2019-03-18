package web.handbook.web;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;

public class HomeControllerUnitTest {
    @Test
    @Ignore
    public void testHomePage()
            throws Exception {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home(Mockito.mock(Model.class)));
    }
}