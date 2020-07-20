/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Taxi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Blondin
 */
@Local
public interface TaxiFacadeLocal {

    void create(Taxi taxi);

    void edit(Taxi taxi);

    void remove(Taxi taxi);

    Taxi find(Object id);

    List<Taxi> findAll();

    List<Taxi> findRange(int[] range);

    int count();
    
}
