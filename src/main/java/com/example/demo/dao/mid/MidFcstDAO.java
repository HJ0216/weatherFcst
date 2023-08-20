package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidFcst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidFcstDAO extends JpaRepository<MidFcst, Long> {

}
