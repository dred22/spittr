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
    public String processRegistration(@Valid Spitter spitter, /*@RequestPart(value="profilePicture", required=false) MultipartFile profilePicture,*/ Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter savedSpitter = spitterRepository.save(spitter);
        return "redirect:/spitter/" + savedSpitter.getUsername();
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