package com.jianaitech.ddd.domain.specification;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AndSpecificationTest {

    @Test
    public void testAnd() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //verify and method
        assertThat(trueSpec.and(trueSpec).isSatisfiedBy(new Object()), is(true));
        assertThat(trueSpec.and(falseSpec).isSatisfiedBy(new Object()), is(false));
        assertThat(falseSpec.and(trueSpec).isSatisfiedBy(new Object()), is(false));
        assertThat(falseSpec.and(falseSpec).isSatisfiedBy(new Object()), is(false));
    }

    @Test
    public void testAndIsSatisfiedBy() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //specifications
        AndSpecification<Object> bothTrueSpecification = new AndSpecification<>(trueSpec, trueSpec);
        AndSpecification<Object> firstFalseThenTrueSpecification = new AndSpecification<>(falseSpec, trueSpec);
        AndSpecification<Object> firstTrueThenFalseSpecification = new AndSpecification<>(trueSpec, falseSpec);
        AndSpecification<Object> bothFalseSpecification = new AndSpecification<>(falseSpec, falseSpec);

        //verify
        assertThat(bothTrueSpecification.isSatisfiedBy(new Object()), is(true));
        assertThat(firstFalseThenTrueSpecification.isSatisfiedBy(new Object()), is(false));
        assertThat(firstTrueThenFalseSpecification.isSatisfiedBy(new Object()), is(false));
        assertThat(bothFalseSpecification.isSatisfiedBy(new Object()), is(false));
    }
}