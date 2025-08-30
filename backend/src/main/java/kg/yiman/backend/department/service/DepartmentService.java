package kg.yiman.backend.department.service;

import kg.yiman.backend.department.dto.DepartmentResponseDTO;
import kg.yiman.backend.department.mapper.DepartmentMapper;
import kg.yiman.backend.department.model.Department;
import kg.yiman.backend.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentService(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public List<DepartmentResponseDTO> findByMedCenterId(UUID medCenterId) {
    List<Department> departments = departmentRepository.findByMedicalCenterId(medCenterId);
    return departments.stream()
        .map(DepartmentMapper::toDTO)
        .toList();
  }
}
