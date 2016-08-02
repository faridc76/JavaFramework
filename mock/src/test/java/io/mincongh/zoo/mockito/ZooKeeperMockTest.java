package io.mincongh.zoo.mockito;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Projection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import io.mincongh.zoo.Animal;
import io.mincongh.zoo.ZooKeeper;

/**
 * Test {@link io.mincongh.zoo.Zeekeeper} without database. We'll use the mock
 * approach.
 *
 * @author Mincong Huang
 */
public class ZooKeeperMockTest {

    private final int ANIMAL_ROWS = 12;

    private SessionFactory mockedSessionFactory;
    private StatelessSession mockedStatelessSession;
    private ScrollableResults mockedScroll;
    private Session mockedSession;
    private Criteria mockedCriteria;

    @Before
    public void setUp() {

        mockedSessionFactory = Mockito.mock(SessionFactory.class);
        mockedStatelessSession = Mockito.mock(StatelessSession.class);
        mockedScroll = Mockito.mock(ScrollableResults.class);
        mockedSession = Mockito.mock(Session.class);
        mockedCriteria = Mockito.mock(Criteria.class);

        Mockito.reset(mockedSessionFactory, mockedSession, mockedCriteria);

        // mock session factory, stateless session, session
        Mockito.when(mockedSessionFactory.openStatelessSession())
                .thenReturn(mockedStatelessSession);
        Mockito.when(mockedStatelessSession.createCriteria(Animal.class))
                .thenReturn(mockedCriteria);
        Mockito.when(mockedSession.createCriteria(Animal.class))
                .thenReturn(mockedCriteria);

        // mock criteria
        Mockito.when(mockedCriteria.setProjection((Projection) Mockito.anyObject()))
                .thenReturn(mockedCriteria);
        Mockito.when(mockedCriteria.setReadOnly(Mockito.anyBoolean()))
                .thenReturn(mockedCriteria);
        Mockito.when(mockedCriteria.setFetchSize(Mockito.anyInt()))
                .thenReturn(mockedCriteria);
        Mockito.when(mockedCriteria.scroll(ScrollMode.FORWARD_ONLY))
                .thenReturn(mockedScroll);
        Mockito.when(mockedCriteria.uniqueResult()).thenReturn((Object) (ANIMAL_ROWS * 1L));

        // mock scrollable results
        Mockito.when(mockedScroll.get(Mockito.anyInt())).thenReturn(new Animal("Rand"));
        OngoingStubbing<Boolean> hasNext = Mockito.when(mockedScroll.next());
        for (int row = 0; row < ANIMAL_ROWS; row++) {
            hasNext = hasNext.thenReturn(true);
        }
        hasNext = hasNext.thenReturn(false);
    }

    @Test
    public void testDoubleCountAnimal() {
        assertEquals(ANIMAL_ROWS * 2, ZooKeeper.doubleCountAnimal(mockedSession));
    }

    @Test
    public void testScrollAnimals() {
        List<Animal> animals = ZooKeeper.scrollAnimals(mockedSessionFactory);
        assertEquals(ANIMAL_ROWS, animals.size());
    }
}
