package com.palo.it.devoxx2015.back.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.logging.Logger;

import com.palo.it.devoxx2015.back.domain.PlayerDTO;
import com.palo.it.devoxx2015.back.persistence.Player;


@Path("/player")
public class PlayerServiceImpl {

	
	@PersistenceContext(unitName = "fablab-mongo-ogm")
	private EntityManager em;
	
	@Inject
	private Logger log;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PlayerDTO test(PlayerDTO PlayerDTO) {
		log.info("Hellooooooo");
		Player persistedPlayer=new Player();
		persistedPlayer.setId("1");
		return copyToPlayerDTO(persistedPlayer);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public PlayerDTO create(PlayerDTO PlayerDTO) {
		Player persistedPlayer=copyToPlayer(PlayerDTO);
		em.persist(persistedPlayer);
		return copyToPlayerDTO(persistedPlayer);
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {
		Player deleted=null;
		deleted=findPlayerById(id);
		em.remove(deleted);
		return Response.noContent().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public PlayerDTO update(PlayerDTO PlayerDTOEntry) {
		Player updated;
		updated = findPlayerById(PlayerDTOEntry.getId());
		em.persist(copyToPlayer(PlayerDTOEntry));	
		return PlayerDTOEntry;
	}

	private Player findPlayerById(String id)  {
		return em.find(Player.class, id);
	}

	public List<PlayerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerDTO findById(String id) {
		Player found=null;
		found=findPlayerById(id);
		
		return copyToPlayerDTO(found);
	}

	private Player copyToPlayer(PlayerDTO playerDTO) {

		if(playerDTO!=null){
			Player copiedPlayer=new Player();
			try {
				BeanUtils.copyProperties(copiedPlayer, playerDTO);
			} catch (IllegalAccessException e) {
				log.error(e);
			} catch (InvocationTargetException e) {
				log.error(e);
			}
			return copiedPlayer;
		}
		
		return null;
	}

	private PlayerDTO copyToPlayerDTO(Player player){
		if(player != null){
			PlayerDTO copiedPlayerDTO=new PlayerDTO();
			try {
				BeanUtils.copyProperties(copiedPlayerDTO, player);
			} catch (IllegalAccessException e) {
				log.error(e);
			} catch (InvocationTargetException e) {
				log.error(e);
			}
			return copiedPlayerDTO;
		}
		return null;

	}


}
