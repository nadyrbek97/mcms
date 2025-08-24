package kg.yiman.backend.medcenter.service;

import kg.yiman.backend.medcenter.dto.MedicalCenterResponseDTO;
import kg.yiman.backend.medcenter.mapper.MedicalCenterMapper;
import kg.yiman.backend.medcenter.model.MedicalCenter;
import kg.yiman.backend.medcenter.repository.MedicalCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCenterService {

  private final MedicalCenterRepository medicalCenterRepository;

  public MedicalCenterService(MedicalCenterRepository medicalCenterRepository) {
    this.medicalCenterRepository = medicalCenterRepository;
  }

  public List<MedicalCenterResponseDTO> getMedicalCenters() {
    List<MedicalCenter> medicalCenters = medicalCenterRepository.findAll();

    return medicalCenters.stream()
        .map(MedicalCenterMapper::toDTO)
        .toList();
  }
}
