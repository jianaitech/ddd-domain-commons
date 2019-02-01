package com.jianaitech.ddd.domain.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;

/**
 * Base class for entities.
 */
public abstract class EntitySupport<ID, E extends Entity> implements Entity<ID, E> {

    private transient Field identityField;

    /**
     * Find identity field.
     *
     * @param cls
     * @return
     */
    private static Field identityFieldDetermination(final Class cls) {
        Field identityField = null;

        for (Field field : cls.getDeclaredFields()) {
            if (field.getAnnotation(Identity.class) != null) {
                field.setAccessible(true);
                if (identityField != null) {
                    throw new IllegalStateException("Only one field can be annotated with " + Identity.class);
                } else {
                    identityField = field;
                }
            }
        }

        if (identityField == null) {
            if (cls == Object.class) {
                throw new IllegalStateException(
                        "This class, or one of its superclasses, " +
                                "must have a unique field annotated with " + Identity.class);
            } else {
                return identityFieldDetermination(cls.getSuperclass());
            }
        }

        return identityField;
    }

    private static <T extends Entity> boolean sameIdentityAs(T entity, T other) {
        if (entity == null) throw new IllegalArgumentException("entity cannot be null");
        return other != null && entity.identity().equals(other.identity());
    }

    @Override
    public final boolean sameIdentityAs(final E other) {
        return sameIdentityAs(this, other);
    }

    @Override
    public final ID identity() {
        if (identityField == null) {
            identityField = identityFieldDetermination(this.getClass());
        }

        try {
            identityField.setAccessible(true);
            return (ID) identityField.get(this);
        } catch (IllegalAccessException e) {
            throw new UnsupportedOperationException("Cannot get identity!", e);
        }
    }

    @Override
    public String describe() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public final int hashCode() {
        ID identity = identity();
        return identity == null ? 0 : identity.hashCode();
    }

    // EqualsBuilder that uses sameIdentity/sameValue,
    // better validation (varargs etc)
    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return sameIdentityAs((E) o);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + identity() + ']';
    }
}
