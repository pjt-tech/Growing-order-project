package notice.growingbulletinboard.service;

import lombok.RequiredArgsConstructor;
import notice.growingbulletinboard.domain.Member;
import notice.growingbulletinboard.domain.item.Item;
import notice.growingbulletinboard.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item) {
        return itemRepository.save(item).getId();
    }

    public Item findMember(Long id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> findMembers() {
        return itemRepository.findAll();
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findById(itemId).get();
        item.update(name, price, stockQuantity);
    }
}
