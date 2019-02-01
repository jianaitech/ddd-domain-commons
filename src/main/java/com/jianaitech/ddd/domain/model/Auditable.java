package com.jianaitech.ddd.domain.model;

/**
 * Auditing with time & changed by
 */
public interface Auditable<U, T> extends Timestamped<T>, ChangedBy<U> {
}