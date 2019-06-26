package co.elmansouri.contact.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.elmansouri.contact.entities.Contact;
import co.elmansouri.contact.service.ContactService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService service;
	
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
	@GetMapping(path = "/contacts")
	public List<Contact> getAll() {
		logger.info("> Liste collaborateur ");
		return service.getAll();
	}
	
	
	/**
	 * Ajouter contact
	 * @param contact
	 * @return
	 */
	@PostMapping(path = "/contacts")
	public ResponseEntity<Contact> add(@Valid @RequestBody Contact contact) {
		return new ResponseEntity<Contact>(service.add(contact), HttpStatus.OK);
	}
	
	
	/**
	 * Modifier Contact
	 * @param contact
	 * @return
	 */
	@PutMapping(path = "/contacts")
	public ResponseEntity<Contact> edit(@Valid @RequestBody Contact contact) {
		return new ResponseEntity<Contact>(service.edit(contact), HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/contacts")
	public ResponseEntity<String> delete(@Valid @RequestBody Contact contact) {
		service.delete(contact);
		return new ResponseEntity<String>("Bien supprimer ", HttpStatus.OK);
	}
	

}
