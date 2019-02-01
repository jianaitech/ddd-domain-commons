package com.jianaitech.ddd.domain.specification;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrSpecificationTest {

    @Test
    public void testOr() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //verify and method
        assertThat(trueSpec.or(trueSpec).isSatisfiedBy(new Object()), is(true));
        assertThat(trueSpec.or(falseSpec).isSatisfiedBy(new Object()), is(true));
        assertThat(falseSpec.or(trueSpec).isSatisfiedBy(new Object()), is(true));
        assertThat(falseSpec.or(falseSpec).isSatisfiedBy(new Object()), is(false));
    }

    @Test
    public void testOrIsSatisfiedBy() {
        AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
        AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

        //specifications
        OrSpecification<Object> bothTrueSpecification = new OrSpecification<>(trueSpec, trueSpec);
        OrSpecification<Object> firstTrueThenFalseSpecification = new OrSpecification<>(falseSpec, trueSpec);
        OrSpecification<Object> firstFalseThenTrueSpecification = new OrSpecification<>(trueSpec, falseSpec);
        OrSpecification<Object> bothFalseSpecification = new OrSpecification<>(falseSpec, falseSpec);

        //verify
        assertThat(bothTrueSpecification.isSatisfiedBy(new Object()), is(true));
        assertThat(firstFalseThenTrueSpecification.isSatisfiedBy(new Object()), is(true));
        assertThat(firstTrueThenFalseSpecification.isSatisfiedBy(new Object()), is(true));
        assertThat(bothFalseSpecification.isSatisfiedBy(new Object()), is(false));
    }
}