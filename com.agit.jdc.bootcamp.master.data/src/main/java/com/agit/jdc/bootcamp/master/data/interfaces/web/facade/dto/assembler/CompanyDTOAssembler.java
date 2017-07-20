package com.agit.jdc.bootcamp.master.data.interfaces.web.facade.dto.assembler;

import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTOBuilder;
import com.agit.jdc.bootcamp.master.data.domain.company.Company;
import com.agit.jdc.bootcamp.master.data.domain.company.CompanyBuilder;
import com.agit.jdc.bootcamp.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lintang
 */
public class CompanyDTOAssembler implements IObjectAssembler<Company, CompanyDTO> {

    @Override
    public CompanyDTO toDTO(Company domainObject) {
        return new CompanyDTOBuilder()
                .setCompanyID(domainObject.getCompanyID())
                .setCompanyName(domainObject.getCompanyName())
                .setCompanyDescription(domainObject.getCompanyDescription())
                .setBusinessGroupID(domainObject.getBusinessGroupID())
                .setAddress(domainObject.getAddress())
                .setNpwp(domainObject.getNpwp())
                .setTelp(domainObject.getTelp())
                .setPlatform(domainObject.getPlatform())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setUpdatedBy(domainObject.getUpdatedBy())
                .setUpdatedDate(domainObject.getUpdatedDate())
                .createCompanyDTO();
    }

    @Override
    public Company toDomain(CompanyDTO dtoObject) {
        return new CompanyBuilder()
                .setCompanyID(dtoObject.getCompanyID())
                .setCompanyName(dtoObject.getCompanyName())
                .setCompanyDescription(dtoObject.getCompanyDescription())
                .setBusinessGroupID(dtoObject.getBusinessGroupID())
                .setAddress(dtoObject.getAddress())
                .setNpwp(dtoObject.getNpwp())
                .setTelp(dtoObject.getTelp())
                .setPlatform(dtoObject.getPlatform())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setUpdatedBy(dtoObject.getUpdatedBy())
                .setUpdatedDate(dtoObject.getUpdatedDate())
                .createCompany();
    }

    public List<CompanyDTO> toDTOs(List<Company> arg0) {
        List<CompanyDTO> res = new ArrayList<>();
        for (Company o : arg0) {
            res.add(toDTO(o));
        }
        return res;
    }

    public List<Company> toDomains(List<CompanyDTO> arg0) {
        List<Company> res = new ArrayList<>();
        for (CompanyDTO o : arg0) {
            res.add(toDomain(o));
        }
        return res;
    }

}
