package kg.yiman.backend.department.controller;

import kg.yiman.backend.department.dto.DepartmentResponseDTO;
import kg.yiman.backend.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
  private final DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public ResponseEntity<List<DepartmentResponseDTO>> findByMedicalCenterId(@RequestParam UUID medCenterId) {
    log.info("REST request to get all departments by medicalCenterId {}", medCenterId);
    if (medCenterId == null) {
      return ResponseEntity.badRequest().build();
    }

    List<DepartmentResponseDTO> departmentResponseDTOs = departmentService.findByMedCenterId(medCenterId);
    return ResponseEntity.ok(departmentResponseDTOs);
  }
}
