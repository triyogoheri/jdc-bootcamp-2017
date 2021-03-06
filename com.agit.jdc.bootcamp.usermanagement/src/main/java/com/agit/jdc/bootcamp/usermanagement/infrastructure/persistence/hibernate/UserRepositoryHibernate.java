package com.agit.jdc.bootcamp.usermanagement.infrastructure.persistence.hibernate;

import com.agit.jdc.bootcamp.infrastructure.hibernate.HibernateRepository;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.usermanagement.domain.user.User;
import com.agit.jdc.bootcamp.usermanagement.domain.user.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bayutridewanto
 */
@Repository
@Transactional
public class UserRepositoryHibernate extends HibernateRepository implements UserRepository {

    @Override
    public void saveOrUpdate(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public User findByID(String userName) {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.in("userName", Arrays.asList(userName.toLowerCase(), userName.toUpperCase())));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> findAllUser() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public List<User> findByParameter(String fullName, String userName, String roleID, StatusData userStatus) {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.like("userName", userName).ignoreCase())
//                .add(Restrictions.or(Restrictions.eq("userStatus", StatusData.ACTIVE), Restrictions.eq("userStatus", StatusData.INACTIVE)));
                .add(Restrictions.eq("userStatus", userStatus));

        if (!fullName.equals("%%")) {
            criteria.add(Restrictions.like("userSpecification.fullName", fullName));
        }

        if (!roleID.equals("%%")) {
            Criteria criteria1 = criteria.createCriteria("role")
                    .add(Restrictions.eq("roleID", roleID));
            return (List<User>) criteria1.list();
        }
        return (List<User>) criteria.list();
    }

    @Override
    public List<User> findByRoleID(String roleID) {
        return findByParameter("%%", "%%", roleID, StatusData.ACTIVE);
    }

    @Override
    public int releaseAll() {
        return getSession().createQuery("update User set userSpecification.userLoginInfo.remoteAddress=null").executeUpdate();
    }

    @Override
    public User findByRemote(String remote) {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.eq("userSpecification.userLoginInfo.remoteAddress", remote));
        return (User) criteria.uniqueResult();
    }

    @Override
    public int count(String roleID) {
        Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.ne("userStatus", StatusData.DELETED));
        Criteria criteria1 = criteria.createCriteria("role").add(Restrictions.eq("roleID", roleID));
        return (int) criteria1.setProjection(Projections.count("roleID")).uniqueResult();
    }

}
