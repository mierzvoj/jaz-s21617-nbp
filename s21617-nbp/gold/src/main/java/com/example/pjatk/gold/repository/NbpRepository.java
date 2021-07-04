package com.example.pjatk.gold.repository;

import com.example.pjatk.gold.model.Gold;
import com.example.pjatk.gold.model.GoldValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpRepository extends JpaRepository<GoldValue, Long> {
}
