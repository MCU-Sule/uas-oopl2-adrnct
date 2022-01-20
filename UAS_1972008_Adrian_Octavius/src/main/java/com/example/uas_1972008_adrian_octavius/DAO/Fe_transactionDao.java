package com.example.uas_1972008_adrian_octavius.DAO;


import com.example.uas_1972008_adrian_octavius.Model.FePointEntity;
import com.example.uas_1972008_adrian_octavius.Model.FeTransactionEntity;
import com.example.uas_1972008_adrian_octavius.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.List;

public class Fe_transactionDao implements DAOInterface<FeTransactionEntity>{
    @Override
    public int addData(FeTransactionEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(FeTransactionEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(FeTransactionEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<FeTransactionEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FeTransactionEntity.class);
        query.from(FeTransactionEntity.class);
        List<FeTransactionEntity> tlist = s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(tlist);
    }
}
