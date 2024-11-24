package umc.study.repository.RegionRepository;

import umc.study.domain.Region;

public interface RegionRepositoryCustom {
    Region findRegionByName(String name);
}
