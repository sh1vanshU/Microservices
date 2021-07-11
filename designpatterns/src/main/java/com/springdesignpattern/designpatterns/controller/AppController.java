/**
 * 
 */
package com.springdesignpattern.designpatterns.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdesignpattern.designpatterns.builder.Contact;
import com.springdesignpattern.designpatterns.builder.ContactBuilder;
import com.springdesignpattern.designpatterns.factory.Pet;
import com.springdesignpattern.designpatterns.factory.PetFactory;

/**
 * @author shivanshu.gua
 */

@RestController
@RequestMapping("/")
public class AppController {

	@Autowired
	private PetFactory petFactory;

	public AppController(PetFactory petFactory) {
		super();
		this.petFactory=petFactory;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	public String getDefault() {
		return "Hello Default Message here, Please concentrate";
	}
	
	@PostMapping("adoptPet/{type}/{name}")
	public Pet adoptPet(@PathVariable String type,@PathVariable String name) {
		Pet pet=this.petFactory.createPet(type);
		pet.setName(name);
		pet.feed();
		return pet;
	}
	
	
	@GetMapping("presidents")
	public List<Contact> getPresidents(){
		// this way you are consuming more time and more lines.
		List<Contact> contacts=new ArrayList<>();
		
		Contact contact=new Contact();
		
		contact.setFirstName("George");
		contact.setLastName("Washington");
		
		contacts.add(contact);
		// this way you need to remember about constructor.
		contacts.add(new Contact("Shivanshu","Gupta","Shivanshu.gupta4@gmail.com"));
		
		// let's use builder pattern here to less lines.
		/*
		 * 1. Useful when object creation has many parameters.
		 * 2. Becomes increasingly more useful when some or all parameters are optional.
		 */
		contacts.add(new ContactBuilder().setFirstName("himanshu").setLastName("gupta").buildContact());
		return contacts;
	}
	
	
}
