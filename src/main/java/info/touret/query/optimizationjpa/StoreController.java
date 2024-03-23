package info.touret.query.optimizationjpa;

import info.touret.query.optimizationjpa.entity.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(value = "/stores", produces = "application/json")
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.findAllStores());
    }

    @GetMapping(value = "/stores/{name}")
    public ResponseEntity<Store> getStoreByName(@PathVariable("name") String name) {
        return ResponseEntity.of(storeService.findByName(name));
    }


}
