package co.elmansouri.contact.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * Liste Contact
	 * @return
	 */
	@GetMapping(path = "contacts")
	public List<Contact> getAll() {
		List<Contact> contacts = this.contactRepository.findAll();
		if(contacts.isEmpty()) {
			return Collections.emptyList();
		} else {
			return contacts;
		}
	}
	
	
	/**
	 * Ajouter contact
	 * @param contact
	 * @return
	 */
	@PostMapping(path = "contacts")
	public ResponseEntity<Contact> add(@Valid @RequestBody Contact contact) {
		return new ResponseEntity<Contact>(this.contactRepository.save(contact), HttpStatus.OK);
	}
	
	
	/**
	 * Modifier Contact
	 * @param contact
	 * @return
	 */
	@PutMapping(path = "contacts")
	public ResponseEntity<Contact> edit(@Valid @RequestBody Contact contact) {
		return new ResponseEntity<Contact>(this.contactRepository.save(contact), HttpStatus.OK);
	}
	

}
