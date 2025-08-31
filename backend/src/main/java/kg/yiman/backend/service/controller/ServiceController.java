package kg.yiman.backend.service.controller;

import kg.yiman.backend.service.dto.ServiceResponseDto;
import kg.yiman.backend.service.service.ServiceService;
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
@RequestMapping("/service")
public class ServiceController {

  private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
  private final ServiceService serviceService;

  public ServiceController(ServiceService serviceService) {
    this.serviceService = serviceService;
  }

  @GetMapping
  public ResponseEntity<List<ServiceResponseDto>> findByDepartmentId(@RequestParam UUID departmentId) {
    log.info("REST request to get all services by departmentId {}", departmentId);
    if (departmentId == null) {
      return ResponseEntity.badRequest().build();
    }

    List<ServiceResponseDto> serviceResponseDtos = serviceService.findByDepartmentId(departmentId);
    return ResponseEntity.ok(serviceResponseDtos);
  }



}
