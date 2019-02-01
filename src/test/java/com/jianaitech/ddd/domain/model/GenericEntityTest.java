package com.jianaitech.ddd.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * @author Co0der
 */
public class GenericEntityTest {
    @Test
    public void id() {
        LocalDateTime createdTime = LocalDateTime.now().minusMinutes(3);
        LocalDateTime lastModifiedTime = createdTime.plusMinutes(5);

        //entity
        GenericEntity entity = new GenericEntity();
        entity.setId(new GenericId("id-2"));
        entity.setCreatedBy("john");
        entity.setCreatedTime(createdTime);
        entity.setLastModifiedBy("tom");
        entity.setLastModifiedTime(lastModifiedTime);
        entity.setVersion(6L);

        //verify
        assertThat(entity.identity(), equalTo(new GenericId("id-2")));
        assertThat(entity.idString(), equalTo("id-2"));
        assertThat(entity.getId(), equalTo(new GenericId("id-2")));

        assertThat(entity.getCreatedBy(), equalTo("john"));
        assertThat(entity.getCreatedTime(), equalTo(createdTime));
        assertThat(entity.getLastModifiedBy(), equalTo("tom"));
        assertThat(entity.getLastModifiedTime(), equalTo(lastModifiedTime));
        assertThat(entity.getVersion(), is(6L));
    }
}