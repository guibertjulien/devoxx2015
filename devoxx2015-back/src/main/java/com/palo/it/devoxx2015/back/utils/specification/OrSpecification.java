package com.palo.it.devoxx2015.back.utils.specification;

public class OrSpecification<T> extends AbstractCompositeSpecification<T> {
    @Override
    public boolean isSatisfiedBy(final T candidate) {
        boolean result = false;
        
        for (Specification<T> specification : this.specifications) {
            result |= specification.isSatisfiedBy(candidate);
        }
        return result;
    }
    
    public OrSpecification(Specification<T>... specifications) {
        super(specifications);
    }
}
