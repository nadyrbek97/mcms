package kg.yiman.backend.medcenter.controller;

import kg.yiman.backend.medcenter.dto.MedicalCenterResponseDTO;
import kg.yiman.backend.medcenter.service.MedicalCenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/med-center")
public class MedicalCenterController {

  private final MedicalCenterService medicalCenterService;

  public MedicalCenterController(MedicalCenterService medicalCenterService) {
    this.medicalCenterService = medicalCenterService;
  }

  public ResponseEntity<List<MedicalCenterResponseDTO>> getMedicalCenters() {
    List<MedicalCenterResponseDTO> medicalCenterResponseDTOs = medicalCenterService.getMedicalCenters();

    return ResponseEntity.ok(medicalCenterResponseDTOs);
  }

}
