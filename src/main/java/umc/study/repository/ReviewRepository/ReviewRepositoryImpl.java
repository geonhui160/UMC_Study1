package umc.study.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public void insertReview(Long memberId, Long storeId, String body, Float score) {
        Member member = entityManager.find(Member.class, memberId);
        Store store = entityManager.find(Store.class, storeId);

        Review review = Review.create(body, score, member, store);

        entityManager.persist(review);
    }
}