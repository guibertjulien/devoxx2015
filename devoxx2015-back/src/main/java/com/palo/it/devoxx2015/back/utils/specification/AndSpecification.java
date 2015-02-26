package com.palo.it.devoxx2015.back.utils.specification;

public class AndSpecification<T> extends AbstractCompositeSpecification<T> {
    
    @Override
    public boolean isSatisfiedBy(final T candidate) {
        boolean result = true;
        
        for (Specification<T> specification : this.specifications) {
            result &= specification.isSatisfiedBy(candidate);
        }
        return result;
    }
    
    public AndSpecification(Specification<T>... specifications) {
        super(specifications);
    }
}