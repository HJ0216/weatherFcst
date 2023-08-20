package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidSeaFcst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidSeaFcstDAO extends JpaRepository<MidSeaFcst, Long> {
}
