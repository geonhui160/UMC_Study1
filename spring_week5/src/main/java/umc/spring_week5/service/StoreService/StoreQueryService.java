package umc.spring_week5.service.StoreService;
import umc.spring_week5.domain.Store;

import java.util.List;
import java.util.Optional;
public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}

