package Week10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Week10.repository.HouseRepository;
import Week10.beans.House;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Mar 28, 2023
 */

@Controller
public class WebController {
	@Autowired
	HouseRepository repo;
	
	@GetMapping("/inputHouse")
	public String addNewHouse(Model model) {
		House h = new House();
		model.addAttribute("newHouse", h);
		return "input";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateHouse(@PathVariable("id") long id, Model model) {
		House h = repo.findById(id).orElse(null);
		model.addAttribute("newHouse", h);
		return "input";
	}
	
	@PostMapping("/inputHouse")
	public String addNewHouse(@ModelAttribute House h, Model model) {
		repo.save(h);
		return viewAllHouses(model);
	}
	
	@PostMapping("/update/{id}")
	public String reviseHouse(House h, Model model) {
		repo.save(h);
		return viewAllHouses(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteHouse(@PathVariable("id") long id, Model model) {
		House h = repo.findById(id).orElse(null);
		repo.delete(h);
		return viewAllHouses(model);
	}
	
	@GetMapping({"/", "viewAll"})
	public String viewAllHouses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewHouse(model);
		}
		model.addAttribute("houses", repo.findAll());
		return "results";
	}

}
