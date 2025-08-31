package kg.yiman.backend.service.mapper;

import kg.yiman.backend.service.dto.ServiceResponseDto;
import kg.yiman.backend.service.model.ServiceModel;

public class ServiceMapper {

  public static ServiceResponseDto toDTO(ServiceModel service) {
    ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
    serviceResponseDto.setId(service.getId().toString());
    serviceResponseDto.setTitle(service.getTitle());
    serviceResponseDto.setDescription(service.getDescription());
    serviceResponseDto.setPrice(service.getPrice());
    serviceResponseDto.setCurrencyCode(service.getCurrencyCode());
    serviceResponseDto.setDepartmentId(service.getDepartment().getId().toString());

    return serviceResponseDto;
  }
}
