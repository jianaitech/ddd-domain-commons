package com.jianaitech.ddd.domain.event;

import java.io.Serializable;

/**
 * Domain event is something that has happened in the past in domain, and does not have a lifecycle.
 */
public interface DomainEvent<T> extends Serializable {

    /**
     * @param other The other domain event.
     * @return <code>true</code> if the given domain event and this event are regarded as being the same event.
     */
    boolean sameEventAs(T other);

}
