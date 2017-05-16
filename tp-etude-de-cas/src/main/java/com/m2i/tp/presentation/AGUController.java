package com.m2i.tp.presentation;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.m2i.tp.dao.entity.User;
import com.m2i.tp.service.IAGUService;

@Controller
public class AGUController {

	@Resource(name="aguService")
	private IAGUService aguService;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Page d'accueil");
		model.addObject("message", "Bienvenue sur la page d'accueil");
		model.setViewName("accueil");
		return model;

	}
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String products(Locale locale, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", aguService.findAllUsers());
		return "users";
	}
	
	@RequestMapping(value = "/saveUser")
	public String saveUser(User u, Model model) {
		// if(p.getId() == 0)
		System.out.println(u);
		System.out.println(u.getId());
		System.out.println(u.getPassword());

		System.out.println(u.getUsername());
		aguService.addOrUpdateUser(u);
		model.addAttribute("user", new User());
		model.addAttribute("users", aguService.findAllUsers());
		return "users";
	}
	
	@RequestMapping(value = "/deleteUser")
	public String delete(int id, Model model) {
		User u = new User();

		u.setId(id);

		aguService.removeUser(u);

		model.addAttribute("user", new User());
		model.addAttribute("users", aguService.findAllUsers());
		return "users";
	}
	
	@RequestMapping(value = "/editUser")
	public String edit(int id, Model model) {
		User u = aguService.findUserById(id);
		model.addAttribute("user", u);
		model.addAttribute("users", aguService.findAllUsers());
		return "users";
	}
	
}
