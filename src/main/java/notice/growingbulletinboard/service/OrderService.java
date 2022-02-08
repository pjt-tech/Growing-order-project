package notice.growingbulletinboard.service;

import lombok.RequiredArgsConstructor;
import notice.growingbulletinboard.domain.Delivery;
import notice.growingbulletinboard.domain.Member;
import notice.growingbulletinboard.domain.Order;
import notice.growingbulletinboard.domain.OrderItem;
import notice.growingbulletinboard.domain.item.Item;
import notice.growingbulletinboard.repository.ItemRepository;
import notice.growingbulletinboard.repository.MemberRepository;
import notice.growingbulletinboard.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티조회
        Member member = memberRepository.findById(memberId).get();
        Item item = itemRepository.findById(itemId).get();

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문저장
        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long id) {
        Order findOrder = orderRepository.findById(id).get();
        findOrder.cancel();
    }

    /*public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }*/
}
