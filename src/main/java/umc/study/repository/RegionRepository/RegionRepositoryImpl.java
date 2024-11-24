package umc.study.repository.RegionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QRegion;
import umc.study.domain.Region;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Region findRegionByName(String regionName){
        QRegion region = QRegion.region;

        return queryFactory
                .selectFrom(region)
                .where(region.name.eq(regionName))
                .fetchOne();
    }
}
