package com.jianaitech.ddd.domain.specification;

import org.junit.Test;

/**
 * @author Co0der
 */
public class CompositeSpecificationTest {

    @Test(expected = UnsupportedOperationException.class)
    public void isSatisfiedBy() {
        new CompositeSpecification().isSatisfiedBy(new Object());
    }
}