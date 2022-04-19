package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 최적화
@RequiredArgsConstructor // final을 가진 변수만 생성자주입을 해줌. (lombok)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional // 쓰기가 있는 메서드 이므로 readOnly false
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); // 동시에 통과하는 경우가 생길 수 있으니까 디비에 유니크 조건을 최후로 넣어야함. 근데 트랜젝션 애너테이션 때매 일관성 만족시켜주는 거 아니가?
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //단건 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
