/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turismo.resources;

import co.edu.uniandes.csw.turismo.dtos.PlanTuristicoDTO;
import co.edu.uniandes.csw.turismo.dtos.PlanTuristicoDetailDTO;
import co.edu.uniandes.csw.turismo.ejb.PlanTuristicoLogic;
import co.edu.uniandes.csw.turismo.entities.PlanTuristicoEntity;
import co.edu.uniandes.csw.turismo.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Christer Osorio
 */
@Path("planesTuristicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped

public class PlanTuristicoResource {

    //para conectar con la logica
    @Inject
    private PlanTuristicoLogic logic;

    //private final ArrayList<Object> listaVacia= new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(PlanTuristicoResource.class.getName());

    @POST
    public PlanTuristicoDTO createPlanTuristico(PlanTuristicoDTO planTuristico) throws BusinessLogicException {

        PlanTuristicoEntity planTuristicoEntity = planTuristico.toEntity();
        planTuristicoEntity = logic.createPlanTuristico(planTuristicoEntity);

        return new PlanTuristicoDTO(planTuristicoEntity);
    }

    @GET
    @Path("{idPlanTuristico: \\d+}")
    public PlanTuristicoDetailDTO getPlanTuristico(@PathParam("idPlanTuristico") Long idPlanTuristico) {
        return null;
    }

    @GET
    public List<PlanTuristicoDetailDTO> getPlanesTuristicos() {
        ArrayList<PlanTuristicoDetailDTO> planes = new ArrayList<>();
        return planes;
    }

    @PUT
    @Path("idPlanTuristico: \\d+}")
    public PlanTuristicoDTO updatePlanTuristico(@PathParam("idPlanTuristico") Long idPlanTuristico, PlanTuristicoDTO planTuristico) {
        return null;
    }

    @DELETE
    @Path("idPlanTuristico: \\d+}")
    public void deletePlanTuristico(@PathParam("idPlanTuristico") Long idPlanTuristico) {

    }

    // Parte para las relaciones con blogs y valoraciones
    /**
     *
     * Conexión con el servicio de valoraciones para un plan.
     * {@link ValoracionResource}
     *
     *
     *
     * Este método conecta la ruta de /planes con las rutas de /valoraciones que
     *
     * dependen del plan, es una redirección al servicio que maneja el segmento
     *
     * de la URL que se encarga de las valoraciones.
     *
     *
     *
     * @param planesId El ID del plan con respecto al cual se accede al
     *
     * servicio.
     *
     * @return El servicio de Valoraciones para ese plan en paricular.\
     *
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     *
     * Error de lógica que se genera cuando no se encuentra el plan.
     *
     */
    @Path("{planesId: ¡Error! Referencia de hipervínculo no válida.")

    public Class<ValoracionResource> getValoracionResource(@PathParam("planesId ") Long planesId) {

        if (logic.getPlanTuristico(planesId) == null) {

            throw new WebApplicationException("El recurso /planes/" + planesId + "/valoraciones no existe.", 404);

        }

        return ValoracionResource.class;

    }

    /**
     *
     * Conexión con el servicio de blogs para un plan.
     * {@link BlogDeViajeroResource}
     *
     *
     *
     * Este método conecta la ruta de /planes con las rutas de /blogs que
     *
     * dependen del plan, es una redirección al servicio que maneja el segmento
     *
     * de la URL que se encarga de los blogs.
     *
     *
     *
     * @param planesId El ID del plan con respecto al cual se accede al
     *
     * servicio.
     *
     * @return El servicio de Blogs para ese plan en paricular.\
     *
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     *
     * Error de lógica que se genera cuando no se encuentra el plan.
     *
     */
    @Path("{planesId: ¡Error! Referencia de hipervínculo no válida.")

    public Class<BlogDeViajeroResource> getBlogDeViajeroResource(@PathParam("planesId ") Long planesId) {

        if (logic.getPlanTuristico(planesId) == null) {

            throw new WebApplicationException("El recurso /planes/" + planesId + "/blogs no existe.", 404);

        }

        return BlogDeViajeroResource.class;

    }
}
