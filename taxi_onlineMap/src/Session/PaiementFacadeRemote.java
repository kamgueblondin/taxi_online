/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Paiement;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Blondin
 */
@Remote
public interface PaiementFacadeRemote {

    void create(Paiement paiement);

    void edit(Paiement paiement);

    void remove(Paiement paiement);

    Paiement find(Object id);

    List<Paiement> findAll();

    List<Paiement> findRange(int[] range);

    int count();
    
}
