package com.jianaitech.ddd.domain.specification;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Co0der
 */
public class ConjunctionSpecificationTest {

    @Test
    public void isSatisfiedBy() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        ConjunctionSpecification<Object> hasFalse = new ConjunctionSpecification<>(trueSpec, trueSpec, falseSpec);
        ConjunctionSpecification<Object> allTrue = new ConjunctionSpecification<>(trueSpec, trueSpec, trueSpec);
        ConjunctionSpecification<Object> allFalse = new ConjunctionSpecification<>(falseSpec, falseSpec, falseSpec);

        //verify
        assertThat(hasFalse.isSatisfiedBy(new Object()), is(false));
        assertThat(allTrue.isSatisfiedBy(new Object()), is(true));
        assertThat(allFalse.isSatisfiedBy(new Object()), is(false));
    }
}