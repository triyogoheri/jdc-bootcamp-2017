package com.agit.jdc.bootcamp.master.data.interfaces.web.rest;

import com.agit.jdc.bootcamp.common.application.CompanyService;
import com.agit.jdc.bootcamp.common.dto.company.CompanyDTO;
import com.agit.jdc.bootcamp.master.data.interfaces.web.facade.CompanyServiceFacade;
import com.agit.jdc.bootcamp.shared.type.PlatformType;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lintang
 */
@Controller
public class CompanyServiceRestImpl implements CompanyServiceFacade {

    @Autowired
    private CompanyService companyService;

    @Override
    @RequestMapping(value = "/jdc.service.company.getDummy", method = RequestMethod.GET)
    public ResponseEntity<CompanyDTO> getDummyData() {
        return new ResponseEntity<>(companyService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.save", method = RequestMethod.POST)
    public ResponseEntity<Void> saveOrUpdate(@RequestBody CompanyDTO company) {
        Validate.notNull(companyService);
        companyService.saveOrUpdate(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteData(@RequestBody CompanyDTO company) {
        Validate.notNull(companyService);
        companyService.deleteData(company);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.getByID/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompanyDTO> findByID(@PathVariable("id") String companyID) {
        CompanyDTO companyDTO = companyService.findByID(companyID);
        if (companyDTO != null) {
            return new ResponseEntity<>((companyDTO), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.geByParameter/{map}", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyDTO>> findByParameter(@PathVariable("map") Map map) {
        List<CompanyDTO> companyDTOs = companyService.findByParameter(map);
        if (!companyDTOs.isEmpty()) {
            return new ResponseEntity<>((companyDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.geByParams/{companyID}/{companyName}/{businessGroupID}/{platform}", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyDTO>> findByParams(@PathVariable("companyID") String companyID, @PathVariable("companyName") String companyName, @PathVariable("businessGroupID") String businessGroupID, @PathVariable("platform") PlatformType platform) {
        List<CompanyDTO> companyDTOs = companyService.findByParams(companyID, companyName, businessGroupID, platform);
        if (!companyDTOs.isEmpty()) {
            return new ResponseEntity<>((companyDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @RequestMapping(value = "/jdc.service.company.getAll", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyDTO>> findAll() {
        List<CompanyDTO> companyDTOs = companyService.findAll();
        if (!companyDTOs.isEmpty()) {
            return new ResponseEntity<>((companyDTOs), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
