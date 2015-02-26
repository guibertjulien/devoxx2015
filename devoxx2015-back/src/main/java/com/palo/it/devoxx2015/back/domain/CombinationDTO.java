package com.palo.it.devoxx2015.back.domain;

import java.util.List;

/**
 * 
 * A combination concerns a targeted item to be assembled with one of the compatible items.
 * A candidate item is proposed by the game.
 *
 *@author Mbenmansour
 *
 */
public class CombinationDTO {

	private ItemDTO targetedtItem;
	private ItemDTO candidateItem;
	private List<ItemDTO> compatibleItems;
	
	
	

	public ItemDTO getTargetedtItem() {
		return targetedtItem;
	}

	public void setTargetedtItem(ItemDTO targetedtItem) {
		this.targetedtItem = targetedtItem;
	}

	public ItemDTO getCandidateItem() {
		return candidateItem;
	}
	
	public void setCandidateItem(ItemDTO candidateItem) {
		this.candidateItem = candidateItem;
	}
	
	public List<ItemDTO> getCompatibleItems() {
		return compatibleItems;
	}
	
	public void setCompatibleItems(List<ItemDTO> compatibleItems) {
		this.compatibleItems = compatibleItems;
	}
	
	
}
