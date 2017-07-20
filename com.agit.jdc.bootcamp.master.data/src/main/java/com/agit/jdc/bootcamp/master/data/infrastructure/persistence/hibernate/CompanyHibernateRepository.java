package com.agit.jdc.bootcamp.master.data.infrastructure.persistence.hibernate;

import com.agit.jdc.bootcamp.infrastructure.hibernate.HibernateRepository;
import com.agit.jdc.bootcamp.master.data.domain.company.Company;
import com.agit.jdc.bootcamp.master.data.domain.company.CompanyRepository;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import com.agit.jdc.bootcamp.util.JDCStringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class CompanyHibernateRepository extends HibernateRepository implements CompanyRepository {

    @Override
    public void saveOrUpdate(Company company) {
        getSession().saveOrUpdate(company);
    }

    @Override
    public void deleteData(Company company) {
        Query query = getSession().createQuery("delete from com.agit.jdc.bootcamp.master.data.domain.company.Company where companyID = :tid");
        query.setParameter("tid", company.getCompanyID());
        query.executeUpdate();
    }

    @Override
    public Company findByID(String companyID) {
        return (Company) getSession()
                .createQuery("from com.agit.jdc.bootcamp.master.data.domain.company.Company where companyID = :tid")
                .setParameter("tid", companyID)
                .uniqueResult();
    }

    @Override
    public List<Company> findByParameter(Map map) {
        Criteria criteria = getSession().createCriteria(Company.class);

        if (JDCStringUtil.hasValue(map.get("companyID"))) {
            criteria.add(Restrictions.like("companyID", "%" + map.get("companyID") + "%").ignoreCase());
        }
        if (JDCStringUtil.hasValue(map.get("companyName"))) {
            criteria.add(Restrictions.like("companyName", "%" + map.get("companyName") + "%").ignoreCase());
        }
        if (JDCStringUtil.hasValue(map.get("businessGroupID"))) {
            criteria.add(Restrictions.like("businessGroupID", "%" + map.get("businessGroupID") + "%").ignoreCase());
        }
        if (JDCStringUtil.hasValue(map.get("platform"))) {
            criteria.add(Restrictions.eq("platform", map.get("platform")));
        }

        return (List<Company>) criteria.list();
    }

    @Override
    public List<Company> findByParams(String companyID, String companyName, String businessGroupID, PlatformType platform) {
        Criteria criteria = getSession().createCriteria(Company.class);

        if (JDCStringUtil.hasValue(companyID)) {
            criteria.add(Restrictions.eq("companyID", companyID));
        }
        if (JDCStringUtil.hasValue(companyName)) {
            criteria.add(Restrictions.eq("companyName", companyName));
        }
        if (JDCStringUtil.hasValue(businessGroupID)) {
            criteria.add(Restrictions.eq("businessGroupID", businessGroupID));
        }
        if (JDCStringUtil.hasValue(platform)) {
            criteria.add(Restrictions.eq("platform", platform));
        }

        return (List<Company>) criteria.list();
    }

    @Override
    public List<Company> findAll() {
        return (List<Company>) getSession()
                .createQuery("from com.agit.jdc.bootcamp.master.data.domain.company.Company")
                .list();
    }

}
