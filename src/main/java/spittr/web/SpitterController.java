package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.data.models.Spitter;
import spittr.exeptions.SpitterNotFoundException;
import spittr.services.SpitterRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, /*@RequestPart(value="profilePicture", required=false) MultipartFile profilePicture,*/ Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter1 = new Spitter();
        spitter1.setFirstName("Magomed");
        spitter1.setLastName("Kadiev");
        Object[] test = {1,"test",2,1, spitter1};
        Spitter savedSpitter = spitterRepository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        model.addAttribute("spitterId", test);
        /*model.addAttribute("myarray", test);*/
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        if(spitter == null){
            throw new SpitterNotFoundException();
        }
        model.addAttribute(spitter);
        return "profile";
    }
}