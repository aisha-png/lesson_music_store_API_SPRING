package com.bnta.music_store.repositories;

import com.bnta.music_store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
