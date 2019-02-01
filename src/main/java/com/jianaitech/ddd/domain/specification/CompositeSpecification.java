package com.jianaitech.ddd.domain.specification;


/**
 * Base implementation of composite {@link Specification} with default
 * implementations for {@code and}, {@code or} and {@code not}.
 * Subclass can only implement the method {@link #isSatisfiedBy(Object)}.
 */
public class CompositeSpecification<T> implements Specification<T> {

    /**
     * {@inheritDoc}
     */
    public boolean isSatisfiedBy(T t) {
        throw new UnsupportedOperationException("Subclass of CompositeSpecification should implement method #isSatisfiedBy(Object)!");
    }

    /**
     * {@inheritDoc}
     */
    public Specification<T> and(final Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }

    /**
     * {@inheritDoc}
     */
    public Specification<T> or(final Specification<T> specification) {
        return new OrSpecification<>(this, specification);
    }

    /**
     * {@inheritDoc}
     */
    public Specification<T> not() {
        return new NotSpecification<>(this);
    }
}
