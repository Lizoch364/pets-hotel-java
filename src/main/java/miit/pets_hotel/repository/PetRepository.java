package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Pet;

@Repository
public class PetRepository {
  public Pet getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Pet.class, id);
    session.close();

    return value;
  }

  public List<Pet> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder petBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Pet> petQuery = petBuilder.createQuery(Pet.class);
    Root<Pet> petRoot = petQuery.from(Pet.class);
    petQuery.orderBy(petBuilder.asc(petRoot.get("id")));

    petQuery.select(petRoot);

    var value = session.createQuery(petQuery).getResultList();
    session.close();

    return value;
  }

  public Pet create(Pet pet) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      session.persist(pet);
    });

    return pet;
  }

  public boolean update(Pet pet) {
    Session session = Hibernate.getSessionFactory().openSession();
    session.beginTransaction();
    Pet petFromDB = session.get(Pet.class, pet.getId());
    petFromDB.setOwner(pet.getOwner());
    petFromDB.setEmployee(pet.getEmployee());
    petFromDB.setSpecies(pet.getSpecies());
    petFromDB.setName(pet.getName());
    petFromDB.setDateOfBirth(pet.getDateOfBirth());
    session.persist(petFromDB);
    session.getTransaction().commit();

    return true;
  }

  public void delete(int id) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      Pet pet = session.get(Pet.class, id);
      session.remove(pet);
    });
  }
}
