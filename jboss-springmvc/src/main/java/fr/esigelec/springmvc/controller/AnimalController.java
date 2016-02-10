package fr.esigelec.springmvc.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/animal")
public class AnimalController {
	
	private Logger log = Logger.getLogger(AnimalController.class);
	
    @RequestMapping(value="/dog", method = RequestMethod.GET)
    public String getDog(Model model) {
    	log.debug("getDog is called.");
        return "dog";
    }

    @RequestMapping(value="/cat", method = RequestMethod.GET)
    public String getCat(Model model) {
    	log.debug("getCat is called.");
    	return "cat";
    }
}
