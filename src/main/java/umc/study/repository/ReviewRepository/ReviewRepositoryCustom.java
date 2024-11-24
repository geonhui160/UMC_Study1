package umc.study.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void insertReview(Long memberId, Long storeId, String body, Float score);
}
