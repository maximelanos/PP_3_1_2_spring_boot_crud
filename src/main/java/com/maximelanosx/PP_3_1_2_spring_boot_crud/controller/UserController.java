package com.maximelanosx.PP_3_1_2_spring_boot_crud.controller;

import com.maximelanosx.PP_3_1_2_spring_boot_crud.models.User;
import com.maximelanosx.PP_3_1_2_spring_boot_crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public String indexAll(Model model) {
		model.addAttribute("users", service.findAll());
		return "index";
	}

	@GetMapping("/user-create")
	public String createUserForm(@ModelAttribute("user") User user){
		return "user-create";
	}

	@PostMapping("/user-create")
	public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return"/user-create";
		}
		service.create(user);
		return "redirect:/";
	}

	@GetMapping("user-delete/{id}")
	public String deleteUser(@PathVariable("id") Long id){
		service.delete(id);
		return "redirect:/";
	}

	@GetMapping("/user-update/{id}")
	public String updateUserForm(@PathVariable("id") Long id, Model model){
		model.addAttribute("user", service.read(id));
		return "user-update";
	}

	@PostMapping("/user-update")
	public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return"/user-update";
		}
		service.update(user);
		return "redirect:/";
	}
}