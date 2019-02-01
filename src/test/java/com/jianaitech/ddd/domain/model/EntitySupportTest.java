package com.jianaitech.ddd.domain.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * @author Co0der
 */
public class EntitySupportTest {

    @Test(expected = IllegalStateException.class)
    public void testNoIdentityAnnotationFail() {
        new NoAnnotationEntity().identity();
    }

    @Test(expected = IllegalStateException.class)
    public void testTwoIdentityAnnotationsFail() {
        new TwoAnnotationsEntity().identity();
    }

    @Test
    public void testOneAnnotationSuccess() {
        OneAnnotationEntity entity = new OneAnnotationEntity("id");

        assertThat(entity.identity(), equalTo("id"));
        assertThat(entity.toString(), equalTo("com.jianaitech.ddd.domain.model.EntitySupportTest$OneAnnotationEntity[id=id]"));
    }

    @Test
    public void testDescribe() {
        assertThat(new OneAnnotationEntity(null).describe(), equalTo("EntitySupportTest.OneAnnotationEntity[id=<null>]"));
        assertThat(new OneAnnotationEntity("1").describe(), equalTo("EntitySupportTest.OneAnnotationEntity[id=1]"));
    }

    @Test
    public void testSameIdentityEqualsHashcode() {
        OneAnnotationEntity entity1 = new OneAnnotationEntity("A");
        OneAnnotationEntity entity2 = new OneAnnotationEntity("A");
        OneAnnotationEntity entity3 = new OneAnnotationEntity("B");

        assertThat(entity1.sameIdentityAs(entity2), is(true));
        assertThat(entity2.sameIdentityAs(entity3), is(false));

        assertThat(entity1.equals(entity2), is(true));
        assertThat(entity1.equals(entity1), is(true));
        assertThat(entity1.equals(null), is(false));
        assertThat(entity2.equals(entity3), is(false));

        assertThat(entity1.hashCode(), equalTo(entity2.hashCode()));
        assertThat(entity2.hashCode(), not(equalTo(entity3.hashCode())));
    }

    static class NoAnnotationEntity extends EntitySupport<String, NoAnnotationEntity> {
    }

    static class OneAnnotationEntity extends EntitySupport<String, OneAnnotationEntity> {
        private
        @Identity
        String id;

        OneAnnotationEntity(String id) {
            this.id = id;
        }
    }

    static class TwoAnnotationsEntity extends EntitySupport<String, TwoAnnotationsEntity> {
        private
        @Identity
        String id1 = "id1";
        private
        @Identity
        String id2 = "id2";
    }
}