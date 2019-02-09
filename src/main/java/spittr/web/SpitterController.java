package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.models.Spitter;
import spittr.exeptions.SpitterNotFoundException;
import spittr.exeptions.SpittleNotFoundException;
import spittr.exeptions.SpittlesNotFoundException;
import spittr.services.SpitterRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/spitter/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/spitter/register", method = POST)
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

    @RequestMapping(value="/spitter/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        if(spitter == null){
            throw new SpitterNotFoundException();
        }
        model.addAttribute(spitter);
        return "profile";
    }


    @RequestMapping(value="/spitter/me", method= RequestMethod.GET)
    public String whoAmI( Model model, Principal principal) {

        String username = principal.getName();
        model.addAttribute(spitterRepository.findByUsername(username));
        return "profile";
    }



    @RequestMapping(value="/spitters", method = RequestMethod.GET)
    public List<Spitter> spittles(Model model,
            @RequestParam(value="max", defaultValue= "9223372036854775807") long max,
            @RequestParam(value="count", defaultValue="20") int count) {
        List<Spitter> spitters = spitterRepository.findSpitters(max, count);
        if(CollectionUtils.isEmpty(spitters)){
            throw new SpittlesNotFoundException();
        }
        //when instead of view name a value is returned, Spring looks for a view with the same name,
        // and if it's a case the model data value name will be composed of his type(s), in this case, it'll be 'spitterList'
        return spitters;
    }

    @RequestMapping(value="/spitters/{spittleId}", method=RequestMethod.GET)
    public String spittle( @PathVariable("spittleId") long spittleId, Model model) {
        Spitter spittle = spitterRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }
}