package miit.pets_hotel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feed", schema = "public")
public class Feed {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "price")
  private double price;

  @ManyToOne
  @JoinColumn(name = "id_type")
  private TypeFeed typeFeed;

  @Column(name = "name")
  private String name;
}
