package com.jianaitech.ddd.domain.event;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Co0der
 */
public class DomainEventSupportTest {
    @Test
    public void sameEventAs() {
        ADomainEvent domain1 = new ADomainEvent("A");
        ADomainEvent domain2 = new ADomainEvent("A");
        ADomainEvent domain3 = new ADomainEvent("B");

        assertThat(domain1.sameEventAs(domain2), is(true));
        assertThat(domain2.sameEventAs(domain1), is(true));

        assertThat(domain1.sameEventAs(domain3), is(false));
        assertThat(domain3.sameEventAs(domain1), is(false));
    }

    private static class ADomainEvent extends DomainEventSupport<ADomainEvent> {
        String s;

        ADomainEvent(String s) {
            this.s = s;
        }
    }
}