/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turismo.persistence;

import co.edu.uniandes.csw.turismo.entities.FacturaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jd.castrellon
 */
@Stateless
public class FacturaPersistence {
    @PersistenceContext(unitName = "turismoPU")
    protected EntityManager em;
    
    public FacturaEntity create(FacturaEntity facturaEntity){
        em.persist(facturaEntity);
        return facturaEntity;
    }
    
    public FacturaEntity find(Long facturaEntityID){
        return em.find(FacturaEntity.class, facturaEntityID);
    }
    
    public List<FacturaEntity> findAll(){
        TypedQuery<FacturaEntity> query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return query.getResultList();
    }
}
