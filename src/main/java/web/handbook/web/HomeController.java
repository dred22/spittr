package web.handbook.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Environment environment;

    @RequestMapping(method = GET)
    public String home(Model model) {
        model.addAttribute("profiles", environment.getActiveProfiles());
        return "index";

    }

}