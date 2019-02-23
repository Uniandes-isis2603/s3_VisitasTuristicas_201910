/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turismo.ejb;

import co.edu.uniandes.csw.turismo.entities.ViajeroEntity;
import co.edu.uniandes.csw.turismo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.turismo.persistence.ViajeroPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class ViajeroLogic {
    
    @Inject
    private ViajeroPersistence persistence;
    
    private static final Logger LOGGER = Logger.getLogger(ViajeroLogic.class.getName());
    
    public ViajeroEntity createViajero(ViajeroEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del viajero");
        
        if(entity.getIdioma() == null) {
            throw new BusinessLogicException("No tiene un idioma");
        }
        if(entity.getNombreUsuario() == null || entity.getNombreUsuario().isEmpty()) throw new BusinessLogicException("El nombre no puede ser vacío");
        if(entity.getTipoDeUsuario() == null) throw new BusinessLogicException("El usuario debe tener un tipo");
        entity = persistence.create(entity);
        return entity;
    }
    
    public ViajeroEntity getViajero(Long pIdViajero) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia búsqueda de un viajero");
        ViajeroEntity viajero = persistence.find(pIdViajero);
        if(viajero == null) throw new BusinessLogicException("No existe ningun viajero con ese id");
        return viajero;
    }
    
    public List<ViajeroEntity> getViajeros() throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de retorno de todos los viajeros");
        List<ViajeroEntity> lista = persistence.findAll();
        if(lista == null) throw new BusinessLogicException("No hay viajeros");
        return lista;
    }
    
    public ViajeroEntity updateViajero(Long pIdViajero, ViajeroEntity nouveau) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia actualizacion de usuario");
        if(nouveau.getIdioma() == null) throw new BusinessLogicException("No tiene un idioma");
        if(nouveau.getNombreUsuario() == null || nouveau.getNombreUsuario().isEmpty()) throw new BusinessLogicException("El nombre no puede ser vacío");
        if(nouveau.getTipoDeUsuario() == null) throw new BusinessLogicException("El usuario debe tener un tipo");
        ViajeroEntity viajeroUpdate = persistence.find(pIdViajero);
        viajeroUpdate = nouveau;
        persistence.update(viajeroUpdate);
        return viajeroUpdate;
    }
    
    public ViajeroEntity deleteViajero(Long pIdViajero) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de eliminacion de viajero");
        ViajeroEntity ret = persistence.find(pIdViajero);
        persistence.delete(pIdViajero);
        if(persistence.find(pIdViajero) != null) throw new BusinessLogicException("No se borró correctamente");
        return ret;
    }
    
}
