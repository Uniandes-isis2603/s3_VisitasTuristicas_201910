/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turismo.dtos;

import co.edu.uniandes.csw.turismo.entities.FacturaEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante modificado por David Fonseca
 */
public class FacturasDTO implements Serializable {
    
    private String descripción;
    //En Entity está como Double; jsgs        
    //private Integer costo;
    private Double costo;
    
    private Long id;
    
    private ViajeroDTO viajero;

    public FacturasDTO()
    {
    }
    
    public FacturasDTO(FacturaEntity ent) {
         if (ent != null) {
            this.id = ent.getId();
            this.descripción = ent.getDescripcion();
            this.costo = ent.getCosto();
            if (ent.getViajero()!= null) {
                this.viajero = new ViajeroDTO(ent.getViajero());
            } else {
                this.viajero = null;
            }
        }
    }
    
     public FacturaEntity toEntity() {
        FacturaEntity reviewEntity = new FacturaEntity();
        reviewEntity.setId(this.id);
        reviewEntity.setCosto(this.costo);
        reviewEntity.setDescripcion(this.descripción);
        if (this.viajero != null) {
            reviewEntity.setViajero(this.viajero.toEntity());
        }
        return reviewEntity;
    }
    
    public ViajeroDTO getViajero()
    {
        return viajero;
    }
    public void setViajero(ViajeroDTO viajero)
    {
        this.viajero=viajero;
    }
    /**
     * @return the descripción
     */
    public String getDescripción() {
        return descripción;
    }

    /**
     * @param descripción the descripción to set
     */
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    /**
     * @return the costo
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
}
