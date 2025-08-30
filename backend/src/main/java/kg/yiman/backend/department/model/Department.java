package kg.yiman.backend.department.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import kg.yiman.backend.medcenter.model.MedicalCenter;

import java.util.UUID;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Size(min = 1, max = 500)
  @Column(nullable = false)
  private String title;

  @Size(min = 1, max = 2000)
  @Column
  private String description;

  @Column
  private String imageUrl;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "medical_center_id", nullable = false)
  private MedicalCenter medicalCenter;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public MedicalCenter getMedicalCenter() {
    return medicalCenter;
  }

  public void setMedicalCenter(MedicalCenter medicalCenter) {
    this.medicalCenter = medicalCenter;
  }
}
