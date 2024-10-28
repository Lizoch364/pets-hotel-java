package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Employee;

@Repository
public class EmployeeRepository {
  public Employee getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Employee.class, id);
    session.close();

    return value;
  }

  public List<Employee> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder employeeBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Employee> employeeQuery = employeeBuilder.createQuery(Employee.class);
    Root<Employee> employeeRoot = employeeQuery.from(Employee.class);
    employeeQuery.orderBy(employeeBuilder.asc(employeeRoot.get("id")));

    employeeQuery.select(employeeRoot);

    var value = session.createQuery(employeeQuery).getResultList();
    session.close();

    return value;
  }

  public Employee create(Employee employee) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      session.persist(employee);
    });

    return employee;
  }

  public boolean update(Employee employee) {
    Session session = Hibernate.getSessionFactory().openSession();
    session.beginTransaction();

    Employee employeeFromDB = session.get(Employee.class, employee.getId());
    employeeFromDB.setName(employee.getName());
    employeeFromDB.setSurname(employee.getSurname());
    employeeFromDB.setMiddle_name(employee.getMiddle_name());
    employeeFromDB.setPost(employee.getPost());
    employeeFromDB.setPhone_number(employee.getPhone_number());

    session.persist(employeeFromDB);
    session.getTransaction().commit();

    return true;
  }

  public void delete(int id) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      Employee employee = session.get(Employee.class, id);
      session.remove(employee);
    });
  }
}
