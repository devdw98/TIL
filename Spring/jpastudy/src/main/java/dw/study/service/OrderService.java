package dw.study.service;

import dw.study.model.Member;
import dw.study.model.item.Item;
import dw.study.repository.MemberRepository;
import dw.study.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    //주문
    public Long order(Long memberId, Long itemId, int count){
        //엔티티 조회
        Member member = memberRepository.findById(memberId).get();
        Item item = itemService.findOne(itemId);
        
    }
}
