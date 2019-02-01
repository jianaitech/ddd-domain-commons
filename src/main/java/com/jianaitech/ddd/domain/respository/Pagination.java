package com.jianaitech.ddd.domain.respository;

/**
 * Simple pagination implementation of {@code Pageable}.
 *
 * @author Co0der
 */
public class Pagination {
    private int start;
    private int size;

    private Pagination(int start, int size) {
        if (start < 0 || size <= 0) {
            throw new IllegalArgumentException("start should >= 0 or size should > 0");
        }
        this.start = start;
        this.size = size;
    }

    public static Pagination pagination(int start, int size) {
        return new Pagination(start, size);
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }
}