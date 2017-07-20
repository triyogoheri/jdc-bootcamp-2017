package com.agit.jdc.bootcamp.usermanagement.application.security;

import java.io.Serializable;

/**
 *
 * @author bayutridewanto
 */
public interface SecurityCache extends Serializable {

    public Object put(String key, Object value);

    public Object remove(String key);

    public Object get(String key);
}
