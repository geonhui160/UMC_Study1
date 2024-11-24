package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreDto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    public Store addStore(StoreRequestDTO.addDTO request){
        String regionName = request.getAddress().split(" ")[0];

        if (regionName.endsWith("시")) {
            regionName = regionName.substring(0, regionName.length() -1);

        }

        Region region = regionRepository.findRegionByName(regionName);

        Store newStore = StoreConverter.toStore(request,region);

        return storeRepository.save(newStore);
    }


}
