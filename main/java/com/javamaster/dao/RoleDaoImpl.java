package com.javamaster.dao;

import com.javamaster.model.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RoleDaoImpl implements  RoleDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Role> getRoles() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        Query<Role> query = session.createQuery(cq);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Role.class);
        crit.add(Restrictions.eq("roleName",name));
        List<Role> results = crit.list();
        Role role = results.get(0);

        return role;
    }
}
