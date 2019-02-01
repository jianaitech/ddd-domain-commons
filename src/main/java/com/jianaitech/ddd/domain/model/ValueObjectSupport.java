package com.jianaitech.ddd.domain.model;

import com.jianaitech.ddd.domain.internal.InternalValueObjectSupport;

import java.io.Serializable;

/**
 * Base class for value objects.
 */
public abstract class ValueObjectSupport<V extends ValueObject> extends InternalValueObjectSupport<V> implements ValueObject<V>, Serializable {

    /**
     * @param other The other auditCollection object.
     * @return True if all non-transient fields are equal.
     */
    @Override
    public final boolean sameValueAs(final V other) {
        return equalTo(other);
    }
}
