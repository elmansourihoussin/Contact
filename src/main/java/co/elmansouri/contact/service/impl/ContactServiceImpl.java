package co.elmansouri.contact.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.elmansouri.contact.entities.Contact;
import co.elmansouri.contact.repository.ContactRepository;
import co.elmansouri.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact edit(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact add(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void delete(Long id) {
		contactRepository.deleteById(id);
	}
	
	@Override
	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}

	@Override
	public List<Contact> getAll() {
		List<Contact> allContact = contactRepository.findAll();
		if(allContact.isEmpty()) {
			return Collections.emptyList();
		} else {
			return allContact;
		}
	}

	@Override
	public Optional<Contact> getContact(Long id) {
		return contactRepository.findById(id);
	}




}
