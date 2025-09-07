package kg.yiman.backend.user.model;
import jakarta.persistence.*;
import kg.yiman.backend.department.model.Department;

import java.util.UUID;

@Entity
@Table(name = "doctors")
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String firstName;
  private String lastName;
  private String specialization;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  // 🔑 link to User (for login/authentication)
  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  // getters & setters
}
