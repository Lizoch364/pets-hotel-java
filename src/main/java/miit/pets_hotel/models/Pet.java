package miit.pets_hotel.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet", schema = "public")
public class Pet {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "id_owner")
  private Owner owner;

  @ManyToOne
  @JoinColumn(name = "id_employee")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "id_species")
  private Species species;

  @Column(name = "name")
  private String name;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;
}
