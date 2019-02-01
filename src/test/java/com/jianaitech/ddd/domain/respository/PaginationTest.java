package com.jianaitech.ddd.domain.respository;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Co0der
 */

public class PaginationTest {
    @Test
    public void pagination() {
        Pagination pagination = Pagination.pagination(20, 10);

        assertThat(pagination.getStart(), is(20));
        assertThat(pagination.getSize(), is(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void paginationWithZeroSize() {
        Pagination.pagination(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void paginationWithNegativeStart() {
        Pagination.pagination(-1, 10);
    }
}
