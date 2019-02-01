package com.jianaitech.ddd.domain.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;

/**
 * @author Co0der
 */
public class GenericIdTest {

    @Test
    public void testConstructor() {
        GenericId id = new GenericId();

        //total 36 hexadecimal: 8-4-4-4-12
        assertThat(id.toString(), matchesPattern("^(([0-9a-fA-F]){8}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fA-F]){12})$"));
    }

    @Test
    public void testEquals() {
        GenericId id = new GenericId();
        GenericId copied = new GenericId(id.toString());
        GenericId another = new GenericId("another");

        //verify
        assertThat(id.equals(copied), is(true));
        assertThat(id.equals(another), is(false));

        assertThat(id.sameValueAs(copied), is(true));
        assertThat(id.sameValueAs(another), is(false));

        assertThat(id.hashCode(), is(copied.hashCode()));
    }

    @Test
    public void testToString() {
        assertThat(new GenericId("id").toString(), equalTo("id"));
    }
}