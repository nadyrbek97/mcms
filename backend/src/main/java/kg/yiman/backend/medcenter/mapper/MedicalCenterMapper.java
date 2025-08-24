package kg.yiman.backend.medcenter.mapper;

import kg.yiman.backend.medcenter.dto.MedicalCenterResponseDTO;
import kg.yiman.backend.medcenter.model.MedicalCenter;

public class MedicalCenterMapper {

  public static MedicalCenterResponseDTO toDTO(MedicalCenter medicalCenter) {
    MedicalCenterResponseDTO medicalCenterResponseDTO = new MedicalCenterResponseDTO();
    medicalCenterResponseDTO.setId(medicalCenter.getId().toString());
    medicalCenterResponseDTO.setTitle(medicalCenter.getTitle());
    medicalCenterResponseDTO.setDescription(medicalCenter.getDescription());
    medicalCenterResponseDTO.setEmail(medicalCenter.getEmail());
    medicalCenterResponseDTO.setInstagramLink(medicalCenter.getInstagramLink());

    return medicalCenterResponseDTO;
  }
}
