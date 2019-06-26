package co.elmansouri.contact.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.elmansouri.contact.entities.Contact;
import co.elmansouri.contact.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ContactIntegrationTest {

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ContactService contactService;
	
	
	/**
	 * Test d'integration pour la methode d'afficher tous les contacts 
	 * @throws Exception
	 */
	@Test
	public void getAll() throws Exception {
		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
		contactService.add(newContact);
		
		mvc.perform(get("/api/contacts")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].nom", is("Alaouii")));
	}
	
	/**
	 * Test d'integration pour la methode d'ajouter contact
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception {
		
		mvc.perform(post("/api/contacts")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"
						+ "\"nom\": \"Alaoui\","
						+ "\"prenom\": \"Ali\","
						+ "\"telephone\": \"064589658\","
						+ "\"email\": \"h.mansouri@gmail.com\","
						+ "\"photo\": \"photo.png\","
						+ "\"sexe\": \"Homme\","
						+ "\"cin\": \"JH25896\","
						+ "\"cv\": \"cv.pdf\","
						+ "\"demandeStage\": \"demande.pdf\""
						+ "}"))
		.andExpect(status().isOk())
		.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.nom").value("Alaoui"));
	}
	
	
	/**
	 * Test d'integration pour la methode modifier contact
	 * @throws Exception
	 */
	@Test
	public void edit() throws Exception {
		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
    	contactService.add(newContact);
    	
		mvc.perform(put("/api/contacts")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"
						+ "\"id\": \"" + newContact.getId() + "\","
						+ "\"nom\": \"Hassnaoui\","
						+ "\"prenom\": \"hassan\","
						+ "\"telephone\": \"064589658\","
						+ "\"email\": \"h.mansouri@gmail.com\","
						+ "\"photo\": \"photo.png\","
						+ "\"sexe\": \"Homme\","
						+ "\"cin\": \"JH25896\","
						+ "\"cv\": \"cv.pdf\","
						+ "\"demandeStage\": \"demande.pdf\""
						+ "}"))
		.andExpect(status().isOk())
		.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.nom").value("Hassnaoui"))
		.andExpect(jsonPath("$.id").value(newContact.getId()));
	}


//	public void delete() {
//		Contact newContact =  new Contact(null, "Alaouii", "Ali", "065897856", "h.mansouri@gmail.com", "profile.png", "Homme", "JH14589", "cv.pdf", "demande.pdf", null, null, null );
//		contactService.add(newContact);
//
//		mvc.perform(delete(1)
//				.contentType(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//	}
	
	
	
	
}
