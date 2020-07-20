/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Proprietaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Blondin
 */
@Stateless
public class ProprietaireFacade extends AbstractFacade<Proprietaire> implements ProprietaireFacadeLocal, Session.ProprietaireFacadeRemote {
    @PersistenceContext(unitName = "taxi_online-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProprietaireFacade() {
        super(Proprietaire.class);
    }
    
}
