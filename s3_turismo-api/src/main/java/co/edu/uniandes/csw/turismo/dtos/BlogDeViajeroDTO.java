/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turismo.dtos;

import java.io.Serializable;
import java.util.ArrayList;

public class BlogDeViajeroDTO implements Serializable {

    /*
	 *Atributo que representa los comentarios realizados en el
	 * blog de viajero correspondiente a un plan turístico
     */
    private ArrayList comentarios;

    /*
	 *Atributo que representa las sugerencias realizadas en el
	 * blog de viajero correspondiente a un plan turístico
     */
    private ArrayList sugerencias;

    /*
	 *Atributo que representa la cantidad de likes recibidos en el blog de viajero
	 * correspondiente a un plan turístico
     */
    private int likes;

    //Métodos

    /*
	 *Método constructor de un Blog de Viajero
     */
    public BlogDeViajeroDTO() {

    }

    //Getters & Setters

    /*
	 *Retornar la lista de comentarios de un blog de viajero
	 *@return comentarios
     */
    public ArrayList getComentarios() {
        return comentarios;
    }

    /*
	 *Cambia la lista de comentarios de un blog de viajero
	 *@param comentarios
     */
    public void setComentarios(ArrayList comentarios) {
        this.comentarios = comentarios;
    }

    /*
	 *Retornar la lista de sugerencias de un blog de viajero
	 *@return sugerencias
     */
    public ArrayList getSugerencias() {
        return sugerencias;
    }

    /*
	 *Cambia la lista de sugerencias de un blog de viajero
	 *@param sugerencias
     */
    public void setSugerencias(ArrayList sugerencias) {
        this.sugerencias = sugerencias;
    }

    /*
	 *Retornar el número de likes de un blog de viajero
	 *@return likes
     */
    public int getLikes() {
        return likes;
    }

    /*
	 *Cambia el número de likes de un blog de viajero
	 *@param likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

}
