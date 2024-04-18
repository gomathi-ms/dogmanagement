package com.example.DMS.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.DMS.Model.Dog;
import com.example.DMS.Model.Trainer;
import com.example.DMS.Repository.DogRepository;
import com.example.DMS.Repository.TrainerRepository;

import java.util.*;
@Controller
public class DogController {
	
	ModelAndView mv =new ModelAndView();
	@Autowired
	DogRepository dogrepo;
	@Autowired
	TrainerRepository trainerrepo;
//@RequestMapping("dogHome")
//public String home() {
//	return "home";
//}
@RequestMapping("dogHome")
public ModelAndView home()
{mv.setViewName("home");
	
	return mv;
}
@RequestMapping("add")
public ModelAndView add()
{
	mv.setViewName("addNewDog.html");
	Iterable<Trainer> trainerlist = trainerrepo.findAll();
	mv.addObject("trainers",trainerlist);
	return mv;
}
@RequestMapping("addNewDog")
public ModelAndView addNewDog(Dog dog,@RequestParam("trainerId")int id)

{ Trainer trainer = trainerrepo.findById(id).orElse(new  Trainer());
	dog.setTrainer(trainer);

	dogrepo.save(dog);
	mv.setViewName("home");
	return mv;
}
@RequestMapping("addTrainer")
public ModelAndView addTrainer()
{mv.setViewName("addNewTrainer");
	
	return mv;
}
@RequestMapping("trainerAdded")
public ModelAndView addNewTrainer(Trainer trainer)
{trainerrepo.save(trainer);
	mv.setViewName("home");
	
	return mv;
}

@RequestMapping("viewModifyDelete")
public ModelAndView ViewDogs()
{ 
	mv.setViewName("viewDogs");
	Iterable<Dog> dogList = dogrepo.findAll();
	mv.addObject("dogs",dogList);

	return mv;
}
@RequestMapping("editDog")
public ModelAndView editDog(Dog dog)
{ dogrepo.save(dog);
	mv.setViewName("editDog");
	return mv;
}
@RequestMapping("deleteDog")
public ModelAndView deleteDog(Dog dog) {
//{    Optional<Dog> dogFound = dogrepo.findById(dog.getId());
//if(dogFound.isPresent())
//{
//	dogrepo.delete(dog);
//}
//return home();
//List<Dog> dogfound = dogrepo.findByname(dog.getName());
//	for(Dog d:dogfound) {
//		dogrepo.delete(d);
//	}
//	return home();
	Dog d =dogrepo.findById(dog.getId()).orElse(new Dog());
	dogrepo.delete(d);
	return home();
}
@RequestMapping("search")
public ModelAndView searchById(int id)
{ Dog dog =dogrepo.findById(id).orElse(new Dog());
	mv.addObject(dog);
	mv.setViewName("searchResults");
	return mv;
}
}
