package com.palo.it.devoxx2015.back.utils.specification;

public interface Specification<T> {
   
	public boolean isSatisfiedBy(T candidate);
    
    public Specification<T> or(Specification<T> specification);
    public Specification<T> and(Specification<T> specification);
    public Specification<T> not();
}