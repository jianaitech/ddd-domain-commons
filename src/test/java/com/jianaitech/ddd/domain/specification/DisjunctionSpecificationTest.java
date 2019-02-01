package com.jianaitech.ddd.domain.specification;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Co0der
 */
public class DisjunctionSpecificationTest {

    @Test
    public void isSatisfiedBy() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        DisjunctionSpecification<Object> hasFalse = new DisjunctionSpecification<>(trueSpec, falseSpec, falseSpec);
        DisjunctionSpecification<Object> allTrue = new DisjunctionSpecification<>(trueSpec, trueSpec, trueSpec);
        DisjunctionSpecification<Object> allFalse = new DisjunctionSpecification<>(falseSpec, falseSpec, falseSpec);

        //verify
        assertThat(hasFalse.isSatisfiedBy(new Object()), is(true));
        assertThat(allTrue.isSatisfiedBy(new Object()), is(true));
        assertThat(allFalse.isSatisfiedBy(new Object()), is(false));
    }
}