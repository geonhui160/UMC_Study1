package umc.study.DTO;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.study.DTO.QMissionRegionDTO is a Querydsl Projection type for MissionRegionDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMissionRegionDTO extends ConstructorExpression<MissionRegionDTO> {

    private static final long serialVersionUID = -1293882218L;

    public QMissionRegionDTO(com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<String> storeName, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<String> missionSpec, com.querydsl.core.types.Expression<Integer> daysLeft) {
        super(MissionRegionDTO.class, new Class<?>[]{long.class, String.class, int.class, String.class, int.class}, missionId, storeName, reward, missionSpec, daysLeft);
    }

}

