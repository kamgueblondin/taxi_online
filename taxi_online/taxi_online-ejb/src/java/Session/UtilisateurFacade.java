/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Blondin
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal, Session.UtilisateurFacadeRemote {
    @PersistenceContext(unitName = "taxi_online-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
}
