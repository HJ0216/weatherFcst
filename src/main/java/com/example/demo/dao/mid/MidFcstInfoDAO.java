package com.example.demo.dao.mid;

import com.example.demo.entity.mid.MidFcst;
import com.example.demo.entity.mid.MidLandFcst;
import com.example.demo.entity.mid.MidSeaFcst;
import com.example.demo.entity.mid.MidTa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MidFcstInfoDAO {

    private final EntityManager em;

    // MidFcst
    public void save(MidFcst midFcst) {
        em.persist(midFcst);
    }
    public List<MidFcst> findAllMidFcst() {
        return em.createQuery("select mf from MidFcst mf", MidFcst.class).getResultList();
    }

    public MidFcst findByWfSv(String wfSv) {
        String query = "select mf from MidFcst mf where mf.wfSv = :wfSv";
        return em.createQuery(query, MidFcst.class)
                .setParameter("wfSv", wfSv)
                .getSingleResult();
    }



    // MidLandFcst
    public void save(MidLandFcst midLandFcst) {
        em.persist(midLandFcst);
    }
    public List<MidLandFcst> findAllMidLandFcst() {
        return em.createQuery("select mlf from MidLandFcst mlf", MidLandFcst.class).getResultList();
    }
    public MidLandFcst findByRegId(String regId) {
        String query = "select mlf from MidLandFcst mlf where mlf.regId = :regId";
        return em.createQuery(query, MidLandFcst.class)
                .setParameter("regId", regId)
                .getSingleResult();
    }


    // MidTa
    public void save(MidTa midTa) {
        em.persist(midTa);
    }
    public List<MidTa> findAllMidTa() {
        return em.createQuery("select mt from MidTa mt", MidTa.class).getResultList();
    }


    // MidSeaFcst
    public void save(MidSeaFcst midSeaFcst) {
        em.persist(midSeaFcst);
    }
    public List<MidSeaFcst> findAllMidSeaFcst() {
        return em.createQuery("select msf from MidSeaFcst msf", MidSeaFcst.class).getResultList();
    }

}
