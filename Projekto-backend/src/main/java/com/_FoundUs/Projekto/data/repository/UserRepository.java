package com._FoundUs.Projekto.data.repository;


import com._FoundUs.Projekto.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
