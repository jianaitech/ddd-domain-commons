package com.jianaitech.ddd.domain.model;

/**
 * Entity version
 */
public interface Versioning<V> {
    /**
     * Entity version
     *
     * @return entity version
     */
    V getVersion();
}
