package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.models.Spittle;
import spittr.exeptions.SpittleNotFoundException;
import spittr.exeptions.SpittlesNotFoundException;
import spittr.services.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max", defaultValue= "9223372036854775807") long max,
            @RequestParam(value="count", defaultValue="20") int count) {
        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
        if(CollectionUtils.isEmpty(spittles)){
            throw new SpittlesNotFoundException();
        }
        return spittles;
    }

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle( @PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }
}