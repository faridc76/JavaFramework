package fr.esigelec.springmvc.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esigelec.springmvc.model.User;

@Controller
@RequestMapping(value = "/login")
public class AuthController {
	
	private Logger log = Logger.getLogger(AuthController.class);
	
    @RequestMapping(method = RequestMethod.POST)
    public String getUser(@ModelAttribute("user") User user, Model model) {
    	log.debug("getUser is called.");
    	model.addAttribute("name", user.getName());
        return "welcome-user";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setForm(Model model) {
    	log.debug("loading page...");
    	model.addAttribute("user", new User());
    	return "login";
    }
}
