package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidFcst;
import com.example.demo.entity.mid.MidLandFcst;
import com.example.demo.entity.mid.MidSeaFcst;
import com.example.demo.entity.mid.MidTa;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.demo.entity.mid.QMidFcst.midFcst;
import static com.example.demo.entity.mid.QMidLandFcst.midLandFcst;
import static com.example.demo.entity.mid.QMidSeaFcst.midSeaFcst;
import static com.example.demo.entity.mid.QMidTa.midTa;

@RequiredArgsConstructor
@Repository
public class MidFcstInfoRepository {

    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;

    // MidFcst
    @Transactional
    public void save(MidFcst midFcst) {
        entityManager.persist(midFcst);
    }

    public List<MidFcst> findAllMidFcst() {
        return queryFactory.selectFrom(midFcst)
                .fetch();
    }

    public List<MidFcst> findByWfSv(String wfSv) {
        return queryFactory.selectFrom(midFcst)
                .where(midFcst.wfSv.eq(wfSv))
                .fetch();
    }


    // MidLandFcst
    @Transactional
    public void save(MidLandFcst midLandFcst) {
        entityManager.persist(midLandFcst);
    }

    public List<MidLandFcst> findAllMidLandFcst() {
        return queryFactory.selectFrom(midLandFcst)
                .fetch();
    }

    public List<MidLandFcst> findByRegIdFromMidLandFcst(String regId) {
        return queryFactory.selectFrom(midLandFcst)
                .where(midLandFcst.regId.eq(regId))
                .fetch();
    }


    // MidTa
    @Transactional
    public void save(MidTa midTa) {
        entityManager.persist(midTa);
    }

    public List<MidTa> findAllMidTa() {
        return queryFactory.selectFrom(midTa)
                .fetch();
    }

    public List<MidTa> findByRegIdFromMidTa(String regId) {
        return queryFactory.selectFrom(midTa)
                .where(midTa.regId.eq(regId))
                .fetch();
    }


    // MidSeaFcst
    @Transactional
    public void save(MidSeaFcst midSeaFcst) {
        entityManager.persist(midSeaFcst);
    }

    public List<MidSeaFcst> findAllMidSeaFcst() {
        return queryFactory.selectFrom(midSeaFcst)
                .fetch();
    }

    public List<MidSeaFcst> findByRegIdFromMidSeaFcst(String regId) {
        return queryFactory.selectFrom(midSeaFcst)
                .where(midSeaFcst.regId.eq(regId))
                .fetch();
    }
}
