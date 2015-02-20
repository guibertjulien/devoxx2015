package com.palo.fablab.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.palo.fablab.domain.PlayerDTO;

public interface PlayerService {
	
	PlayerDTO create(PlayerDTO PlayerDTO);
	Response delete(String id);
	PlayerDTO update(PlayerDTO PlayerDTOEntry);
	List<PlayerDTO> findAll();
	PlayerDTO findById(String id);
	
	
	
}
