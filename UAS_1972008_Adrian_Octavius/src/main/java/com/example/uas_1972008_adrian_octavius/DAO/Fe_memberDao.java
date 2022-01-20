package com.example.uas_1972008_adrian_octavius.DAO;

import com.example.uas_1972008_adrian_octavius.Model.FeMemberEntity;
import com.example.uas_1972008_adrian_octavius.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Fe_memberDao implements DAOInterface<FeMemberEntity>{

    @Override
    public int addData(FeMemberEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(FeMemberEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(FeMemberEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<FeMemberEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FeMemberEntity.class);
        query.from(FeMemberEntity.class);
        List<FeMemberEntity> mlist = s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(mlist);
    }
}
