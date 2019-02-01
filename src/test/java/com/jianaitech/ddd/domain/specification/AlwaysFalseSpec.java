package com.jianaitech.ddd.domain.specification;

public class AlwaysFalseSpec extends CompositeSpecification<Object> {
    public boolean isSatisfiedBy(Object o) {
        return false;
    }
}