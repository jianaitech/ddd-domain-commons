package com.jianaitech.ddd.domain.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Default generate uuid for distributed system, we prefer uuid/guid for better performance.
 *
 * @author Co0der
 */
public final class GenericId implements ValueObject<GenericId>, Serializable {
    private String id;

    public GenericId() {
        this(UUID.randomUUID().toString());
    }

    public GenericId(String id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true; //quick return
        if (o == null || getClass() != o.getClass()) return false;

        GenericId genericId = (GenericId) o;
        return id.equals(genericId.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public final String toString() {
        return id;
    }

    @Override
    public boolean sameValueAs(GenericId other) {
        return other != null && this.id.equals(other.id);
    }
}
