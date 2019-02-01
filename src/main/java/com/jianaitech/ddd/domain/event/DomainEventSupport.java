package com.jianaitech.ddd.domain.event;

import com.jianaitech.ddd.domain.internal.InternalValueObjectSupport;

/**
 * Base class for domain event objects.
 *
 * @author Co0der
 */
public abstract class DomainEventSupport<T extends DomainEventSupport> extends InternalValueObjectSupport<T>
        implements DomainEvent<T> {

    @Override
    public boolean sameEventAs(T other) {
        return equalTo(other);
    }
}
