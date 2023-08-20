package com.example.demo.dao.srt;

import com.example.demo.entity.srt.UltraSrtFcst;
import com.example.demo.entity.srt.UltraSrtNcst;
import com.example.demo.entity.srt.VilageFcst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SrtFcstInfoDAO {

    private final EntityManager em;

    // UltraSrtNcst
    public void save(UltraSrtNcst ultraSrtNcst){
        em.persist(ultraSrtNcst);
    }

    public List<UltraSrtNcst> findAllUltraSrtNcst() {
        return em.createQuery("select usn from UltraSrtNcst usn", UltraSrtNcst.class).getResultList();
    }


    // UltraSrtFcst
    public void save(UltraSrtFcst ultraSrtFcst){
        em.persist(ultraSrtFcst);
    }
    public List<UltraSrtFcst> findAllUltraSrtFcst() {
        return em.createQuery("select usf from UltraSrtFcst usf", UltraSrtFcst.class).getResultList();
    }


    // VilageFcst
    public void save(VilageFcst vilageFcst){
        em.persist(vilageFcst);
    }
    public List<VilageFcst> findAllVilageFcst() {
        return em.createQuery("select vgf from VilageFcst vgf", VilageFcst.class).getResultList();
    }

}
