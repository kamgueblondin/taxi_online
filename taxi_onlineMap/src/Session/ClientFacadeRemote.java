/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Client;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Blondin
 */
@Remote
public interface ClientFacadeRemote {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
}
