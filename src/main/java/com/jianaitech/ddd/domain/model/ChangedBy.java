package com.jianaitech.ddd.domain.model;

/**
 * Auditing changed by
 * Date: 4/11/13
 * Time: 9:58 PM
 */
public interface ChangedBy<U> {
    U getCreatedBy();

    U getLastModifiedBy();
}
