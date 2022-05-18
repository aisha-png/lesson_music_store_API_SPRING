package com.bnta.music_store.repositories;

import com.bnta.music_store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//todo: test with and without @Component annotation
public interface ProductRepository extends JpaRepository<Product, Long> {
}
