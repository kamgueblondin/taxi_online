/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Car;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Blondin
 */
@Remote
public interface CarFacadeRemote {

    void create(Car car);

    void edit(Car car);

    void remove(Car car);

    Car find(Object id);

    List<Car> findAll();

    List<Car> findRange(int[] range);

    int count();
    
}
