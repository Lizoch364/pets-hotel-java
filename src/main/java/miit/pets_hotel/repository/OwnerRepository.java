package miit.pets_hotel.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.hibernate.query.MutationQuery;
import org.springframework.stereotype.Repository;

import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Owner;

@Repository
public class OwnerRepository {

  public List<Owner> getAllOwners() {
    AtomicReference<List<Owner>> owners = new AtomicReference<>(new ArrayList<>());

    Hibernate.getSessionFactory().inSession(session -> {
      List<Owner> ownersFromDB = session.createQuery("select o from Owner o order by o.id asc", Owner.class)
        .getResultList();

      owners.set(ownersFromDB);
    });

    return owners.get();
  }

  public Owner getById(int id) {
    AtomicReference<List<Owner>> owners = new AtomicReference<>(new ArrayList<>());

    Hibernate.getSessionFactory().inSession(session -> {
      List<Owner> ownerFromDB = session.createSelectionQuery("where id = :id", Owner.class)
        .setParameter("id", id)
        .getResultList();

      owners.set(ownerFromDB);
    });

    if (owners.get().isEmpty()){
      return null;
    }

    return owners.get().get(0);
  }

  public Owner createOwner(Owner owner) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      MutationQuery query = session.createMutationQuery("insert into Owner (name, surname, middle_name) values (:name, :surname, :middle_name)")
        .setParameter("name", owner.getName())
        .setParameter("surname", owner.getSurname())
        .setParameter("middle_name", owner.getMiddle_name());
      query.executeUpdate();
    });

    return owner;
  }

  public Owner updateOwner(Owner owner) {

    Hibernate.getSessionFactory().inTransaction(session -> {
      MutationQuery query = session.createMutationQuery("update Owner set name = :name, surname = :surname, middle_name = :middle_name where id = :id")
        .setParameter("name", owner.getName())
        .setParameter("surname", owner.getSurname())
        .setParameter("middle_name", owner.getMiddle_name())
        .setParameter("id", owner.getId());
      query.executeUpdate();
    });

    return owner;
  }

  public void deleteOwner(int id) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      MutationQuery query = session.createMutationQuery("delete Owner where id = :id")
        .setParameter("id", id);
      query.executeUpdate();
    });
  }
}
