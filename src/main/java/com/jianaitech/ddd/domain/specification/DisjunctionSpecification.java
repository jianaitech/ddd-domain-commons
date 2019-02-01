package com.jianaitech.ddd.domain.specification;

/**
 * Created with IntelliJ IDEA.
 * AuditUser: Liougehooa
 * Date: 4/18/13
 * Time: 8:52 AM
 * To change this homhon use File | Settings | File Templates.
 */
public class DisjunctionSpecification<T> extends CompositeSpecification<T> {
    private Specification<T>[] disjunction;

    public DisjunctionSpecification(Specification<T>... disjunction) {
        this.disjunction = disjunction;
    }

    public boolean isSatisfiedBy(T candidate) {
        for (Specification<T> spec : disjunction) {
            if (spec.isSatisfiedBy(candidate))
                return true;
        }

        return false;
    }
}
