package com.jianaitech.ddd.domain.model;

import java.io.Serializable;

/**
 * An entity, as aggregation root explained in the DDD book.
 */
public interface Entity<ID, E> extends Serializable {
    /**
     * Entities have an identity.
     *
     * @return The identity of this entity.
     */
    ID identity();

    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other The other entity.
     * @return true if the identities are the same, regardles of other attributes.
     */
    boolean sameIdentityAs(E other);

    /**
     * @return entity description to describe all fields of current state
     */
    String describe();
}
