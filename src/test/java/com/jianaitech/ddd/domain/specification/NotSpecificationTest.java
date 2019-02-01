package com.jianaitech.ddd.domain.specification;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NotSpecificationTest {

    @Test
    public void testNot() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //verify and method
        MatcherAssert.assertThat(trueSpec.not().isSatisfiedBy(new Object()), is(false));
        MatcherAssert.assertThat(falseSpec.not().isSatisfiedBy(new Object()), is(true));
    }

    @Test
    public void testNotIsSatisfiedBy() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //specifications
        NotSpecification<Object> notTrueSpecification = new NotSpecification<>(trueSpec);
        NotSpecification<Object> notFalseSpecification = new NotSpecification<>(falseSpec);

        //verify
        assertThat(notTrueSpecification.isSatisfiedBy(new Object()), is(false));
        assertThat(notFalseSpecification.isSatisfiedBy(new Object()), is(true));
    }
}