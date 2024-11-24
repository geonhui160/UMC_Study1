package umc.study.repository.MemberRepository;

import umc.study.DTO.MemberDTO;

public interface MemberRepositoryCustom {
    MemberDTO findMemberById(Long memberId);
}