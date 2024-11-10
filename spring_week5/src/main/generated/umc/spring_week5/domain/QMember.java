package umc.spring_week5.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -554175352L;

    public static final QMember member = new QMember("member1");

    public final umc.spring_week5.domain.common.QBaseEntity _super = new umc.spring_week5.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring_week5.domain.enums.Gender> gender = createEnum("gender", umc.spring_week5.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.spring_week5.domain.mapping.MemberAgree, umc.spring_week5.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.spring_week5.domain.mapping.MemberAgree, umc.spring_week5.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.spring_week5.domain.mapping.MemberAgree.class, umc.spring_week5.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring_week5.domain.mapping.MemberMission, umc.spring_week5.domain.mapping.QMemberMission> memberMissionList = this.<umc.spring_week5.domain.mapping.MemberMission, umc.spring_week5.domain.mapping.QMemberMission>createList("memberMissionList", umc.spring_week5.domain.mapping.MemberMission.class, umc.spring_week5.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring_week5.domain.mapping.MemberPrefer, umc.spring_week5.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring_week5.domain.mapping.MemberPrefer, umc.spring_week5.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring_week5.domain.mapping.MemberPrefer.class, umc.spring_week5.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring_week5.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring_week5.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring_week5.domain.enums.MemberStatus> status = createEnum("status", umc.spring_week5.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

