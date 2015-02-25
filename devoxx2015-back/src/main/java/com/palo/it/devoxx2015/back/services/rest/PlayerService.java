package com.palo.it.devoxx2015.back.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palo.it.devoxx2015.back.model.Player;
import com.palo.it.devoxx2015.back.services.dao.AbstractRestCrud;

@Path("/player")
public class PlayerService extends AbstractRestCrud<Player, Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    @Override
    protected Class<? extends Player> initType() {
        return Player.class;
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Player test() {
        Player player = new Player();
        player.setUid(1L);
        player.setFirstName("Joe");
        player.setLastName("Foobar");
        player.setEmail("joe@foobar.org");
        player.setJob("Star");
        return player;
    }
}
