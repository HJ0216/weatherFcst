package com.example.demo.dao.srt;

import com.example.demo.entity.srt.UltraSrtFcst;
import com.example.demo.entity.srt.UltraSrtNcst;
import com.example.demo.entity.srt.VilageFcst;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.demo.entity.srt.QUltraSrtNcst.ultraSrtNcst;
import static com.example.demo.entity.srt.QUltraSrtFcst.ultraSrtFcst;
import static com.example.demo.entity.srt.QVilageFcst.vilageFcst;

@RequiredArgsConstructor
@Repository
public class SrtFcstInfoRepository {

    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public void save(UltraSrtNcst ultraSrtNcst) {
        entityManager.persist(ultraSrtNcst);
    }
    public List<UltraSrtNcst> findAllUltraSrtNcst() {
        return queryFactory.selectFrom(ultraSrtNcst)
                .fetch();
    }


    // UltraSrtFcst
    @Transactional
    public void save(UltraSrtFcst ultraSrtFcst) {
        entityManager.persist(ultraSrtFcst);
    }
    public List<UltraSrtFcst> findAllUltraSrtFcst() {
        return queryFactory.selectFrom(ultraSrtFcst)
                .fetch();
    }


    // VilageFcst
    @Transactional
    public void save(VilageFcst vilageFcst) {
        entityManager.persist(vilageFcst);
    }
    public List<VilageFcst> findAllVilageFcst() {
        return queryFactory.selectFrom(vilageFcst)
                .fetch();
    }


}
