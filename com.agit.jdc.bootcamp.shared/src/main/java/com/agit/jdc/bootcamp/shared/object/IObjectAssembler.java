package com.agit.jdc.bootcamp.shared.object;

/**
 *
 * @author bayutridewanto
 */
public interface IObjectAssembler<X,Y> {
    Y toDTO(X domainObject);
    X toDomain(Y dtoObject);
}
