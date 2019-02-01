package com.jianaitech.ddd.domain.specification;

/**
 * Created with IntelliJ IDEA.
 * AuditUser: Liougehooa
 * Date: 4/18/13
 * Time: 8:51 AM
 * To change this homhon use File | Settings | File Templates.
 */
public class ConjunctionSpecification<T> extends CompositeSpecification<T> {
    private Specification<T>[] conjunction;

    public ConjunctionSpecification(Specification<T>... conjunction) {
        this.conjunction = conjunction;
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<T> spec : conjunction) {
            if (!spec.isSatisfiedBy(candidate))
                return false;
        }

        return true;
    }
}
