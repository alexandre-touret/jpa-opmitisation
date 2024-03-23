package info.touret.query.optimizationjpa;

import info.touret.query.optimizationjpa.entity.Store;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @EntityGraph(value = "store[books]")
    Optional<Store> findByName(String name);

    @Query(value = "from Store store JOIN FETCH store.books books")
    @Cacheable("stores")
    Set<Store> findStores();

    Page<Store> findStores(Pageable pageable);

    Slice<Store> findStoresSlice(Pageable pageable);
}
