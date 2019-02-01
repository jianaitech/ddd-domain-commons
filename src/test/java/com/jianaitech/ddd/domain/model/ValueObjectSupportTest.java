package com.jianaitech.ddd.domain.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * @author Co0der
 */
public class ValueObjectSupportTest {
    @Test
    public void testEquals() {
        final AValueObject vo1 = new AValueObject("A");
        final AValueObject vo2 = new AValueObject("A");
        final BValueObject vo3 = new BValueObject("A", 1);

        assertThat(vo1, equalTo(vo2));
        assertThat(vo2, equalTo(vo1));
        assertThat(vo2, not(equalTo(vo3)));
        assertThat(vo3, not(equalTo(vo2)));

        assertThat(vo1.sameValueAs(vo2), is(true));
        assertThat(vo2.sameValueAs(vo3), is(false));
    }

    class AValueObject extends ValueObjectSupport<AValueObject> {
        String s;

        AValueObject(String s) {
            this.s = s;
        }

        AValueObject() {
        }
    }

    class BValueObject extends AValueObject {
        int x;

        BValueObject(String s, int x) {
            super(s);
            this.x = x;
        }

    }
}