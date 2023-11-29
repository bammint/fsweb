package com.example.member.repository;

import com.example.member.entity.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LodgingRepository extends JpaRepository<Lodging, Long> {
}
