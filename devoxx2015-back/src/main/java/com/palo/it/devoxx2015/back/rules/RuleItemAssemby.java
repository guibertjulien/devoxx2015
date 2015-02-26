package com.palo.it.devoxx2015.back.rules;

import java.util.List;
import java.util.Optional;

import com.palo.it.devoxx2015.back.domain.CombinationDTO;
import com.palo.it.devoxx2015.back.domain.ItemDTO;
import com.palo.it.devoxx2015.back.utils.specification.LeafSpecification;


/**
 * This rule guarantees that a candidate item is correctly assembled with
 * a targeted item.
 * 
 * @author Mbenmansour
 *
 * @param <T>
 */
public class RuleItemAssemby<T> extends LeafSpecification<CombinationDTO> {

	@Override
	public boolean isSatisfiedBy(CombinationDTO combination) {
		
		List<ItemDTO> compatibleItems=combination.getCompatibleItems();
		
		Optional<ItemDTO> compatibleItem= compatibleItems
				.stream()
				.filter((item) -> item.equals(combination.getCandidateItem()))
				.findAny();
		
		
		return compatibleItem.isPresent();
	}

}
