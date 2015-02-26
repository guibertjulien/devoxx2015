package com.palo.it.devoxx2015.back.domain;

/**
 * 
 * This class is the finest element of a product.
 *
 *@author Mbenmansour
 */

public class ItemDTO {

	private Long id;
	private String name;
	private String category;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public boolean equals(Object o){
		
	    if(o==null ||!(o instanceof ItemDTO) )
	    	return false;

	    ItemDTO other = (ItemDTO) o;
	    if(this.getId()!=other.getId()){
	    	return false;
	    }
	    if(this.getName()!=other.getName()){
	    	return false;
	    }
	    if(this.getCategory()!=other.getCategory()){
	    	return false;
	    }
	    return true;
	    
	}
	
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        return result;
	    }
	
}
