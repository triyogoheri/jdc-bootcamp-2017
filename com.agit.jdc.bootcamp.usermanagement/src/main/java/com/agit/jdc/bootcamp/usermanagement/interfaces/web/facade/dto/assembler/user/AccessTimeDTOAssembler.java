package com.agit.jdc.bootcamp.usermanagement.interfaces.web.facade.dto.assembler.user;

import com.agit.jdc.bootcamp.common.dto.usermanagement.AccessTimeDTO;
import com.agit.jdc.bootcamp.common.dto.usermanagement.AccessTimeDTOBuilder;
import com.agit.jdc.bootcamp.shared.object.IObjectAssembler;
import com.agit.jdc.bootcamp.usermanagement.domain.user.AccessTime;
import com.agit.jdc.bootcamp.usermanagement.domain.user.AccessTimeBuilder;

/**
 *
 * @author bayutridewanto
 */
public class AccessTimeDTOAssembler implements IObjectAssembler<AccessTime, AccessTimeDTO> {

    @Override
    public AccessTimeDTO toDTO(AccessTime domainObject) {
        return new AccessTimeDTOBuilder()
                .setMondayStart(domainObject.getMondayStart())
                .setMondayEnd(domainObject.getMondayEnd())
                .setTuesdayStart(domainObject.getTuesdayStart())
                .setTuesdayEnd(domainObject.getTuesdayEnd())
                .setWednesdayStart(domainObject.getWednesdayStart())
                .setWednesdayEnd(domainObject.getWednesdayEnd())
                .setThursdayStart(domainObject.getThursdayStart())
                .setThursdayEnd(domainObject.getThursdayEnd())
                .setFridayStart(domainObject.getFridayStart())
                .setFridayEnd(domainObject.getFridayEnd())
                .setSaturdayStart(domainObject.getSaturdayStart())
                .setSaturdayEnd(domainObject.getSaturdayEnd())
                .setSundayStart(domainObject.getSundayStart())
                .setSundayEnd(domainObject.getSundayEnd())
                .createAccessTimeDTO();
    }

    @Override
    public AccessTime toDomain(AccessTimeDTO dtoObject) {
        return new AccessTimeBuilder()
                .setMondayStart(dtoObject.getMondayStart())
                .setMondayEnd(dtoObject.getMondayEnd())
                .setTuesdayStart(dtoObject.getTuesdayStart())
                .setTuesdayEnd(dtoObject.getTuesdayEnd())
                .setWednesdayStart(dtoObject.getWednesdayStart())
                .setWednesdayEnd(dtoObject.getWednesdayEnd())
                .setThursdayStart(dtoObject.getThursdayStart())
                .setThursdayEnd(dtoObject.getThursdayEnd())
                .setFridayStart(dtoObject.getFridayStart())
                .setFridayEnd(dtoObject.getFridayEnd())
                .setSaturdayStart(dtoObject.getSaturdayStart())
                .setSaturdayEnd(dtoObject.getSaturdayEnd())
                .setSundayStart(dtoObject.getSundayStart())
                .setSundayEnd(dtoObject.getSundayEnd())
                .createAccessTime();
    }

}
