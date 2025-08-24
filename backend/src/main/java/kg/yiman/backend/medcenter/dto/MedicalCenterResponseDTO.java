package kg.yiman.backend.medcenter.dto;

public class MedicalCenterResponseDTO {
  private String id;
  private String title;
  private String description;
  private String email;
  private String instagramLink;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getInstagramLink() {
    return instagramLink;
  }

  public void setInstagramLink(String instagramLink) {
    this.instagramLink = instagramLink;
  }
}
