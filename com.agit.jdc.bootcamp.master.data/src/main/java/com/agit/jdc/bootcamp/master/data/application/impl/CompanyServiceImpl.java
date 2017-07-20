package com.agit.jdc.bootcamp.master.data.application.impl;

import com.agit.jdc.bootcamp.common.application.CompanyService;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTOBuilder;
import com.agit.jdc.bootcamp.master.data.domain.company.Company;
import com.agit.jdc.bootcamp.master.data.domain.company.CompanyRepository;
import com.agit.jdc.bootcamp.master.data.interfaces.web.facade.dto.assembler.CompanyDTOAssembler;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import com.agit.jdc.bootcamp.util.JDCStringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author lintang
 */
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private CompanyDTOAssembler companyDTOAssembler;

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void setCompanyDTOAssembler(CompanyDTOAssembler companyDTOAssembler) {
        this.companyDTOAssembler = companyDTOAssembler;
    }

    @Override
    public CompanyDTO getDummyData() {
        CompanyDTO company = new CompanyDTOBuilder()
                .setCompanyID(UUID.randomUUID().toString())
                .setCompanyName("PT. AGIT")
                .setCompanyDescription("Astra Graphia Information Technology")
                .setBusinessGroupID("01")
                .setAddress("Jl. Karet Kuningan No. 52 Jakarta Selatan")
                .setNpwp("123456789")
                .setTelp("02112345")
                .setCreatedDate(new Date())
                .setCreatedBy("SYSTEM")
                .setUpdatedDate(null)
                .setUpdatedBy(null)
                .createCompanyDTO();
        return company;
    }

    @Override
    public void saveOrUpdate(CompanyDTO company) {
        Company comp = companyRepository.findByID(company.getCompanyID());
        if (comp == null) {
            comp = companyDTOAssembler.toDomain(company);
        } else {
            /* update specification */
            comp.assignNewCompany(companyDTOAssembler.toDomain(company));
        }

        companyRepository.saveOrUpdate(comp);
    }

    @Override
    public void deleteData(CompanyDTO company) {
        if (company != null) {
            Company c = companyDTOAssembler.toDomain(company);
            companyRepository.deleteData(c);
        }
    }

    @Override
    public CompanyDTO findByID(String companyID) {
        Validate.notNull(companyRepository);
        Company company = companyRepository.findByID(companyID);
        if (JDCStringUtil.hasValue(company)) {
            return companyDTOAssembler.toDTO(company);
        }
        return new CompanyDTO();
    }

    @Override
    public List<CompanyDTO> findByParameter(Map map) {
        Validate.notNull(companyRepository);
        List<Company> listCompany = companyRepository.findByParameter(map);
        if (listCompany != null) {
            return (List<CompanyDTO>) companyDTOAssembler.toDTOs(listCompany);
        }
        return new ArrayList<>();
    }

    @Override
    public List<CompanyDTO> findByParams(String companyID, String companyName, String businessGroupID, PlatformType platform) {
        Validate.notNull(companyRepository);
        List<Company> listCompany = companyRepository.findByParams(companyID, companyName, businessGroupID, platform);
        if (listCompany != null) {
            return (List<CompanyDTO>) companyDTOAssembler.toDTOs(listCompany);
        }
        return new ArrayList<>();
    }

    @Override
    public List<CompanyDTO> findAll() {
        Validate.notNull(companyRepository);
        return (List<CompanyDTO>) companyDTOAssembler.toDTOs((List<Company>) companyRepository.findAll());
    }

}
