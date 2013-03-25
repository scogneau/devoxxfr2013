package se.citerus.dddsample.domain.shared.experimental;

import junit.framework.TestCase;
import org.junit.Ignore;

public class EntitySupportTest extends TestCase {


    public void testOneAnnotationSuccess() {
        OneAnnotationEntity entity = new OneAnnotationEntity("id");
        assertEquals("id", entity.identity());
    }

    public void testSameIdentityEqualsHashcode() {
        OneAnnotationEntity entity1 = new OneAnnotationEntity("A");
        OneAnnotationEntity entity2 = new OneAnnotationEntity("A");
        OneAnnotationEntity entity3 = new OneAnnotationEntity("B");

        assertTrue(entity1.sameIdentityAs(entity2));
        assertFalse(entity2.sameIdentityAs(entity3));

        assertTrue(entity1.equals(entity2));
        assertFalse(entity2.equals(entity3));

        assertTrue(entity1.hashCode() == entity2.hashCode());
        assertFalse(entity2.hashCode() == entity3.hashCode());
    }

    class NoAnnotationEntity extends EntitySupport<NoAnnotationEntity, String> {
    }

    class OneAnnotationEntity extends EntitySupport<OneAnnotationEntity, String> {
        private @Identity String id;

        OneAnnotationEntity(String id) {
            this.id = id;
        }
    }

    class TwoAnnotationsEntity extends EntitySupport<TwoAnnotationsEntity, String> {
        private @Identity String id1 = "id1";
        private @Identity String id2 = "id2";
    }

}
