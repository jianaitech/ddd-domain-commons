package com.jianaitech.ddd.domain.model;

import java.time.LocalDateTime;

/**
 * @author Co0der
 * @create 2018/12/01 10:19
 */
public class GenericEntity<E extends GenericEntity> extends EntitySupport<GenericId, E>
        implements Auditable<String, LocalDateTime>, Versioning<Long> {
    @Identity
    protected GenericId id;

    private String createdBy;

    private LocalDateTime createdTime;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedTime;

    private Long version;

    /**
     * String value of id
     *
     * @return
     */
    public String idString() {
        return id == null ? "" : id.toString();
    }

    public GenericId getId() {
        return id;
    }

    public void setId(GenericId id) {
        this.id = id;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @SuppressWarnings("unused")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @SuppressWarnings("unused")
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @SuppressWarnings("unused")
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    @SuppressWarnings("unused")
    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
