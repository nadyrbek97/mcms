package kg.yiman.backend.department.mapper;

import kg.yiman.backend.department.dto.DepartmentResponseDTO;
import kg.yiman.backend.department.model.Department;

public class DepartmentMapper {

  public static DepartmentResponseDTO toDTO(Department department) {
    DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
    departmentResponseDTO.setId(department.getId().toString());
    departmentResponseDTO.setTitle(department.getTitle());
    departmentResponseDTO.setDescription(department.getDescription());
    departmentResponseDTO.setImageUrl(department.getImageUrl());
    departmentResponseDTO.setMedicalCenterId(department.getMedicalCenter().getId().toString());
    return departmentResponseDTO;
  }
}
