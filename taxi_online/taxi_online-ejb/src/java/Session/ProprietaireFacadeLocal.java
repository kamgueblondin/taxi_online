/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Proprietaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Blondin
 */
@Local
public interface ProprietaireFacadeLocal {

    void create(Proprietaire proprietaire);

    void edit(Proprietaire proprietaire);

    void remove(Proprietaire proprietaire);

    Proprietaire find(Object id);

    List<Proprietaire> findAll();

    List<Proprietaire> findRange(int[] range);

    int count();
    
}
