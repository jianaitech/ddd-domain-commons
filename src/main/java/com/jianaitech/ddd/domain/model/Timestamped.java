package com.jianaitech.ddd.domain.model;

/**
 * Auditing changed time
 */
public interface Timestamped<T> {
    /**
     * Creation time
     *
     * @return creation time
     */
    T getCreatedTime();

    /**
     * Last modified time
     *
     * @return last modified time
     */
    T getLastModifiedTime();
}