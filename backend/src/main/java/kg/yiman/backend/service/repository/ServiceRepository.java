package kg.yiman.backend.service.repository;

import kg.yiman.backend.service.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {

  List<ServiceModel> findByDepartmentId(UUID departmentId);
}
