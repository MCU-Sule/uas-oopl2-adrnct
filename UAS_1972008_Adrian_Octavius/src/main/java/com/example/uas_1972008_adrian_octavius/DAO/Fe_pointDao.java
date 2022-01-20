package com.example.uas_1972008_adrian_octavius.DAO;

import com.example.uas_1972008_adrian_octavius.Model.FeMemberEntity;
import com.example.uas_1972008_adrian_octavius.Model.FePointEntity;
import com.example.uas_1972008_adrian_octavius.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
public class Fe_pointDao implements DAOInterface<FePointEntity> {

    @Override
    public int addData(FePointEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(FePointEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(FePointEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<FePointEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FePointEntity.class);
        query.from(FePointEntity.class);
        List<FePointEntity> plist = s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(plist);
    }
}
