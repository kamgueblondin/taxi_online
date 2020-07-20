/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Chauffeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Blondin
 */
@Local
public interface ChauffeurFacadeLocal {

    void create(Chauffeur chauffeur);

    void edit(Chauffeur chauffeur);

    void remove(Chauffeur chauffeur);

    Chauffeur find(Object id);

    List<Chauffeur> findAll();

    List<Chauffeur> findRange(int[] range);

    int count();
    
}
