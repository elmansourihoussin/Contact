package co.elmansouri.contact.service;

import java.util.List;
import java.util.Optional;

import co.elmansouri.contact.entities.Contact;

public interface ContactService {
	
	Contact edit(Contact contact);
	Contact add(Contact contact);
	void delete(Long id);
	void delete(Contact contact);
	List<Contact> getAll();
	Optional<Contact> getContact(Long id);
	

}
