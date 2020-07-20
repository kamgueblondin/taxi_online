/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Destinataire;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Blondin
 */
@Remote
public interface DestinataireFacadeRemote {

    void create(Destinataire destinataire);

    void edit(Destinataire destinataire);

    void remove(Destinataire destinataire);

    Destinataire find(Object id);

    List<Destinataire> findAll();

    List<Destinataire> findRange(int[] range);

    int count();
    
}
