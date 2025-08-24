package kg.yiman.backend.medcenter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class MedicalCenter {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotBlank(message = "Title cannot be empty")
  @Size(max = 200, message = "Title cannot exceed 200 character")
  @Column(nullable = false)
  private String title;

  @Size(max = 500, message = "Description cannot exceed 500 character")
  @Column
  private String description;

  @Email(message = "Please provide valid email address")
  @NotBlank(message = "Email cannot be blank")
  @Size(max = 255, message = "Email cannot exceed 255 characters")
  @Column(nullable = false, unique = true)
  private String email;

  @Size(max = 1000, message = "Instagram link cannot exceed 1000 characters")
  @Column
  private String instagramLink;

}
