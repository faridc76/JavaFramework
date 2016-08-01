package io.mincongh.zoo.mockito;

import static org.junit.Assert.assertEquals;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.mincongh.zoo.Animal;
import io.mincongh.zoo.ZooKeeper;

/**
 * Test {@link io.mincongh.zoo.Zeekeeper} without database. We'll use the mock approach.
 *
 * @author Mincong Huang
 */
public class ZooKeeperMockTest {

  private static final Animal[] animals = new Animal[] {new Animal("Cat"), new Animal("Dog")};
  private Session mockedSession;
  private Criteria mockedCriteria;

  @Before
  public void setUp() {
    mockedSession = Mockito.mock(Session.class);
    mockedCriteria = Mockito.mock(Criteria.class);

    Mockito.reset(mockedSession, mockedCriteria);
    // mock session
    Mockito.when(mockedSession.createCriteria(Animal.class)).thenReturn(mockedCriteria);
    // mock criteria
    Mockito.when(mockedCriteria.setProjection((Projection) Mockito.anyObject())).thenReturn(mockedCriteria);
    Mockito.when(mockedCriteria.uniqueResult()).thenReturn((Object) (animals.length * 1L));
  }

  @Test
  public void testDoubleCountAnimal() {
    assertEquals(animals.length * 2, ZooKeeper.doubleCountAnimal(mockedSession));
  }
}
