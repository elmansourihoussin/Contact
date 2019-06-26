package co.elmansouri.contact.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import co.elmansouri.contact.entities.Contact;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ContactRepository contactRepository;
	
	/**
	 * Test Ajouter contact
	 */
	@Test
	public void add() {
		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
		entityManager.persist(newContact);
		entityManager.flush();
		
		Contact resultAdd = contactRepository.save(newContact);
		
		assertThat(newContact).isEqualTo(resultAdd);
	}
	
	
	/**
	 * Test Afficher tous les contacts
	 */
	public void getAll() {
		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
		entityManager.persist(newContact);
		entityManager.flush();
		
		List<Contact> allContact = contactRepository.findAll();
		
		assertThat(allContact.size()).isEqualTo(1);
	}
	
	
	/**
	 * Test Supprimer contact
	 */
	public void delete() {
		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
		entityManager.persist(newContact);
		entityManager.flush();
		
		contactRepository.delete(newContact);
		
		assertThat(contactRepository.findAll()).isEmpty();
	}
	
	
	

}
