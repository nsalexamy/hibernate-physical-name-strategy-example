package com.alexamy.example.hibernate.naming.domain.repository;

import com.alexamy.example.hibernate.naming.domain.model.MedrecHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedrecHistoryRepository extends JpaRepository<MedrecHistory, Long> {
}
