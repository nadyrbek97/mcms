package kg.yiman.backend.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name; // e.g. ROLE_SUPER_ADMIN, ROLE_ADMIN, ROLE_DOCTOR
}
