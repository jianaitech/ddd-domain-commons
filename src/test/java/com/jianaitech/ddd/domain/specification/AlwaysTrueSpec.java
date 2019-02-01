package com.jianaitech.ddd.domain.specification;

public class AlwaysTrueSpec extends CompositeSpecification<Object> {
    public boolean isSatisfiedBy(Object o) {
        return true;
    }
}
