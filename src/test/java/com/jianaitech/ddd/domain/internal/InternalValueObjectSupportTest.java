package com.jianaitech.ddd.domain.internal;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author Co0der
 */
public class InternalValueObjectSupportTest {

    @Test
    public void testGenericEqualTo() {
        ConcreteGenericValueObject concreteGeneric = new ConcreteGenericValueObject(1, "A");
        ConcreteGenericValueObject differentGeneric = new ConcreteGenericValueObject(2, "B");
        ConcreteGenericValueObject sameGeneric = new ConcreteGenericValueObject(1, "A");

        //verify
        assertThat(concreteGeneric, equalTo(concreteGeneric));

        //different or null
        assertThat(concreteGeneric, not(equalTo(new Object())));
        assertThat(concreteGeneric.equalTo(null), is(false));

        assertThat(concreteGeneric, not(equalTo(differentGeneric)));
        assertThat(concreteGeneric.equalTo(differentGeneric), is(false));

        assertThat(concreteGeneric, equalTo(sameGeneric));
        assertThat(concreteGeneric.equalTo(sameGeneric), is(true));

        assertThat(concreteGeneric.hashCode(), is(sameGeneric.hashCode()));
    }

    @Test
    public void testEqualTo() {
        ConcreteValueObject concrete = new ConcreteValueObject(1, "A");
        ConcreteValueObject different = new ConcreteValueObject(2, "B");
        ConcreteValueObject same = new ConcreteValueObject(1, "A");

        //verify
        assertThat(concrete, equalTo(concrete));

        //different
        assertThat(concrete.equalTo(new Object()), is(false));
        assertThat(concrete, not(equalTo(new Object())));
        assertThat(concrete.equalTo(null), is(false));

        assertThat(concrete, not(equalTo(different)));
        assertThat(concrete.equalTo(different), is(false));

        assertThat(concrete, equalTo(same));
        assertThat(concrete.equalTo(same), is(true));

        assertThat(concrete.hashCode(), is(same.hashCode()));
    }

    @Test
    public void testToString() {
        assertThat(new ConcreteGenericValueObject(1, "A").toString(), equalTo("InternalValueObjectSupportTest.ConcreteGenericValueObject[intValue=1,stringValue=A]"));
        assertThat(new ConcreteValueObject(1, "A").toString(), equalTo("InternalValueObjectSupportTest.ConcreteValueObject[intValue=1,stringValue=A]"));
    }

    @SuppressFBWarnings("URF_UNREAD_FIELD")
    private static class ConcreteGenericValueObject extends InternalValueObjectSupport<ConcreteGenericValueObject> {
        private int intValue;
        private String stringValue;

        public ConcreteGenericValueObject(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
        }
    }

    @SuppressFBWarnings("URF_UNREAD_FIELD")
    private static class ConcreteValueObject extends InternalValueObjectSupport {
        private int intValue;
        private String stringValue;

        public ConcreteValueObject(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
        }
    }
}