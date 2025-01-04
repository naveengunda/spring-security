package rest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/login")
	public ModelAndView getMessage() {
		ModelAndView md = new ModelAndView("login");
		return md;
	}
}
