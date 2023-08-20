package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidLandFcst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidLandFcstDAO extends JpaRepository<MidLandFcst, Long> {
}
