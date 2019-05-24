package co.elmansouri.contact.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.elmansouri.contact.entities.Contact;
import co.elmansouri.contact.repository.ContactRepository;

@CrossOrigin("*")
@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public ContactController() {
	}
	
	
	@GetMapping(path = "/msg")
	public String msg() {
		return "Hello platform Stagiaires are fine !!";
	}
	
	
	@GetMapping(path = "contacts")
	public List<Contact> getAll() {
		List<Contact> contacts = this.contactRepository.findAll();
		if(contacts.isEmpty()) {
			return Collections.emptyList();
		} else {
			return contacts;
		}
	}
	

}
