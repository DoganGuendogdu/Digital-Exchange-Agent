package com.digital_exchange_agent.backend.repository;

import com.digital_exchange_agent.backend.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {
}
