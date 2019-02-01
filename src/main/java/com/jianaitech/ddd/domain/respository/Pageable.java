package com.jianaitech.ddd.domain.respository;

/**
 * interface of pagination information.
 *
 * @author Co0der
 */
public interface Pageable {
    /**
     * Returns the start number to be taken according to the underlying page and page size.
     *
     * @return the start number to be taken
     */
    int getStart();

    /**
     * Returns the size of the page items.
     *
     * @return the size of items of that page
     */
    int getSize();
}
