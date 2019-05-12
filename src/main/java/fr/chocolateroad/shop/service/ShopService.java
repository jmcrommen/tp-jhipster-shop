package fr.chocolateroad.shop.service;

import fr.chocolateroad.shop.domain.Shop;
import fr.chocolateroad.shop.repository.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Shop}.
 */
@Service
@Transactional
public class ShopService {

    private final Logger log = LoggerFactory.getLogger(ShopService.class);

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    /**
     * Save a shop.
     *
     * @param shop the entity to save.
     * @return the persisted entity.
     */
    public Shop save(Shop shop) {
        log.debug("Request to save Shop : {}", shop);
        return shopRepository.save(shop);
    }

    /**
     * Get all the shops.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Shop> findAll(Pageable pageable) {
        log.debug("Request to get all Shops");
        return shopRepository.findAll(pageable);
    }


    /**
     * Get one shop by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Shop> findOne(Long id) {
        log.debug("Request to get Shop : {}", id);
        return shopRepository.findById(id);
    }

    /**
     * Delete the shop by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Shop : {}", id);
        shopRepository.deleteById(id);
    }
}
