package notice.growingbulletinboard.web;

import lombok.RequiredArgsConstructor;
import notice.growingbulletinboard.repository.OrderSearch;
import notice.growingbulletinboard.service.ItemService;
import notice.growingbulletinboard.service.MemberService;
import notice.growingbulletinboard.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createOrderForm(Model model) {
        model.addAttribute("members", memberService.findMembers());
        model.addAttribute("items", itemService.findItems());

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String createOrder(@RequestParam Long memberId,
                              @RequestParam Long itemId,
                              @RequestParam int count) {
        orderService.order(memberId, itemId, count);

        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String getOrderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String orderCancel(@PathVariable("orderId")Long id) {
        orderService.cancelOrder(id);

        return "redirect:/orders";
    }
}
