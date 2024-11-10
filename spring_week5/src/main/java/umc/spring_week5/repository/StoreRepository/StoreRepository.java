package umc.spring_week5.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring_week5.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}