package kg.yiman.backend.service.service;

import kg.yiman.backend.service.dto.ServiceResponseDto;
import kg.yiman.backend.service.mapper.ServiceMapper;
import kg.yiman.backend.service.model.ServiceModel;
import kg.yiman.backend.service.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceService {

  private final ServiceRepository serviceRepository;

  public ServiceService(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  public List<ServiceResponseDto> findByDepartmentId(UUID departmentId) {
    List<ServiceModel> serviceModelList = serviceRepository.findByDepartmentId(departmentId);

    return serviceModelList.stream()
        .map(ServiceMapper::toDTO)
        .toList();
  }


}
