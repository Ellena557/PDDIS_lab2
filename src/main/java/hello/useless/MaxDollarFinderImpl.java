package hello.useless;

import hello.Application;
import hello.RbkDb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MaxDollarFinderImpl implements Application.MaxDollarFinder {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List getMaxCurrency() {
        return manager.createQuery("select max(currency) from rbkDollars", RbkDb.class).getResultList();
    }
}
