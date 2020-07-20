/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Taxi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Blondin
 */
@Stateless
public class TaxiFacade extends AbstractFacade<Taxi> implements TaxiFacadeLocal, Session.TaxiFacadeRemote {
    @PersistenceContext(unitName = "taxi_online-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TaxiFacade() {
        super(Taxi.class);
    }
    
}
