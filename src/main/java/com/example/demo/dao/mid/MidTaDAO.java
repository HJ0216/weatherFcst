package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidTa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidTaDAO extends JpaRepository<MidTa, Long> {
}