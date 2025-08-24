package kg.yiman.backend.medcenter.repository;

import kg.yiman.backend.medcenter.model.MedicalCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalCenterRepository extends JpaRepository<MedicalCenter, UUID> {
}
