package info.touret.query.optimizationjpa;

import info.touret.query.optimizationjpa.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAllStores() {
        return storeRepository.findStores().stream().toList();
    }

    public Optional<Store> findByName(String name) {
        return storeRepository.findByName(name);
    }


}
