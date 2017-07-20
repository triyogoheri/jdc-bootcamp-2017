package com.agit.jdc.bootcamp.usermanagement.application.security;

import com.agit.jdc.bootcamp.common.application.RoleService;
import com.agit.jdc.bootcamp.common.application.UserService;
import com.agit.jdc.bootcamp.common.security.UserDetailsImpl;
import com.agit.jdc.bootcamp.common.dto.usermanagement.UserDTO;
import com.agit.jdc.bootcamp.shared.type.StatusData;
import com.agit.jdc.bootcamp.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author bayutridewanto
 *
 */
public class UserDetailsService {
    
    UserService userService;
    RoleService roleService;

    private final Integer MAX_ATTEMPTS = 3;

    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = null;
        try {
            user = userService.findByID(username.toLowerCase());
            if (user.getUserName() == null) {
                throw new UsernameNotFoundException("JDCSecurity.notFound");
            }
        } catch (ResourceAccessException e) {
            /* if connection is refused */
            throw new AuthenticationServiceException("JDCSecurity.connectionRefuse");
        }

        List<GrantedAuthority> authorities = SecurityCacheHelper.getAuthorities(user.getRoleDTO().getRoleID());
        if (authorities == null) {
            List<String> grantedAuthoritys = roleService.grantedAuthoritys(user.getRoleDTO().getRoleID());
            authorities = grantedAuthorities(grantedAuthoritys);
            SecurityCacheHelper.setAuthorities(user.getRoleDTO().getRoleID(), authorities);
        }
        boolean credentialsNonExpired = checkNonExpired(user.getUserSpecificationDTO().getUserLoginInfoDTO().getCredentialsExpiredDate());
        boolean userNonLocked = user.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt() < MAX_ATTEMPTS;
        return new UserDetailsImpl(user.getUserName(), user.getPassword(), user.getUserStatus() == StatusData.ACTIVE, true, credentialsNonExpired, userNonLocked, authorities, user);
    }

    protected List<GrantedAuthority> grantedAuthorities(List<String> rolePrivilegeDTOs) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String auth : rolePrivilegeDTOs) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        return authorities;
    }

    protected boolean checkNonExpired(Date expiredDate) {
        if (expiredDate == null) {
            return true;
        }
        Date now = DateUtil.getDateWithoutTime(new Date());
        return expiredDate.compareTo(now) > 0;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
