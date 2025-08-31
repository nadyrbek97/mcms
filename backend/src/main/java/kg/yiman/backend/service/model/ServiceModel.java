package kg.yiman.backend.service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import kg.yiman.backend.department.model.Department;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "service")
public class ServiceModel {

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

  @NotNull
  @PositiveOrZero
  @Column(nullable = false)
  private BigDecimal price;

  @Size(max = 3, message = "Currency code cannot exceed 3 character")
  @Column(nullable = false)
  private String currencyCode;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

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

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
