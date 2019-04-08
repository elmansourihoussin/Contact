package co.elmansouri.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.elmansouri.contact.entities.Contact;


@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
