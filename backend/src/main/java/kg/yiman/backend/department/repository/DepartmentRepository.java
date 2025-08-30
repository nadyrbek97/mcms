package kg.yiman.backend.department.repository;

import kg.yiman.backend.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

  List<Department> findByMedicalCenterId(UUID medicalCenterId);

};
