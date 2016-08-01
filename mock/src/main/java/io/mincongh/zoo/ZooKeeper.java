package io.mincongh.zoo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 * @author Mincong Huang
 */
public class ZooKeeper {

  public static int doubleCountAnimal(Session session) {
    Criteria criteria = session.createCriteria(Animal.class);
    criteria = criteria.setProjection(Projections.rowCount());
    long rowCount = (long) criteria.uniqueResult();
    return (int) rowCount * 2;
  }
}
