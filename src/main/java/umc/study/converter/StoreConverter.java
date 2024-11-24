package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreDto.StoreRequestDTO;
import umc.study.web.dto.StoreDto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO .addResultDTO toAddResultDTO(Store store){
        return StoreResponseDTO.addResultDTO.builder()
                .storeId(store.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addDTO request, Region region){
        return Store.builder()
                .address(request.getAddress())
                .region(region)
                .name(request.getName())
                .build();
    }
}
