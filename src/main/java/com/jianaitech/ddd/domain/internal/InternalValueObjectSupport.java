package com.jianaitech.ddd.domain.internal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Internal class for immutable value classes.
 *
 * @author Co0der
 */
public abstract class InternalValueObjectSupport<V> {
    private transient int cachedHashCode = 0;

    /**
     * @param other The other value object.
     * @return True if all non-transient fields are equal.
     */
    protected final boolean equalTo(final V other) {
        return other != null && EqualsBuilder.reflectionEquals(this, other, false);
    }

    /**
     * @return Hash code built from all non-transient fields.
     */
    @Override
    public int hashCode() {
        // Using a local variable to ensure that we only do a single read
        // of the cachedHashCode field, to avoid race conditions.
        // It doesn't matter if several threads compute the hash code and overwrite
        // each other, but it's important that we never return 0, which could happen
        // with multiple reads of the cachedHashCode field.
        //
        // See java.lang.String.hashCode()
        int h = cachedHashCode;
        if (h == 0) {
            // Lazy initialization of hash code.
            // Value objects are immutable, so the hash code never changes.
            h = HashCodeBuilder.reflectionHashCode(this, false);
            cachedHashCode = h;
        }

        return h;
    }

    /**
     * @param o other object
     * @return True if other object has the same auditCollection as this auditCollection object.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return equalTo((V) o);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
