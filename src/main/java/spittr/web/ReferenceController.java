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
import spittr.data.models.Reference;
import spittr.exeptions.ReferenceNotFoundException;
import spittr.exeptions.ReferencesNotFoundException;
import spittr.services.ReferencesService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ReferenceController {

    private ReferencesService referencesService;

    @Autowired
    ReferenceController(ReferencesService referencesService) {
        this.referencesService = referencesService;
    }

    @RequestMapping(value = "/reference/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Reference());
        return "registerForm";
    }

    @RequestMapping(value = "/reference/register", method = POST)
    public String processRegistration(@Valid Reference reference, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Reference savedReference = referencesService.save(reference);
        model.addAttribute("username", reference.getUsername());
        return "redirect:/reference/{username}";
    }

    @RequestMapping(value = "/reference/{username}", method = GET)
    public String showreferenceProfile(
            @PathVariable String username, Model model) {
        Reference reference = referencesService.findByUsername(username);
        if (reference == null) {
            throw new ReferenceNotFoundException();
        }
        model.addAttribute(reference);
        return "profile";
    }


    @RequestMapping(value = "/reference/me", method = RequestMethod.GET)
    public String whoAmI(Model model, Principal principal) {

        String username = principal.getName();
        model.addAttribute(referencesService.findByUsername(username));
        return "profile";
    }


    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public List<Reference> spittles(Model model,
                                    @RequestParam(value = "max", defaultValue = "9223372036854775807") long max,
                                    @RequestParam(value = "count", defaultValue = "20") int count) {
        List<Reference> references = referencesService.findReferences(max, count);
        if (CollectionUtils.isEmpty(references)) {
            throw new ReferencesNotFoundException();
        }
        //when instead of view name a value is returned, Spring looks for a view with the same name,
        // and if it's a case the model data value name will be composed of his type(s), in this case, it'll be 'referenceList'
        return references;
    }

    @RequestMapping(value = "/references/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Reference reference = referencesService.findOne(spittleId);
        if (reference == null) {
            throw new ReferenceNotFoundException();
        }
        model.addAttribute(reference);
        return "reference";
    }
}