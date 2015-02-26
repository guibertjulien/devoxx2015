package com.palo.it.devoxx2015.back.utils.specification;

@SuppressWarnings("unchecked")
public class NotSpecification<T> extends AbstractCompositeSpecification<T> {
    
    @Override
    public boolean isSatisfiedBy(final T candidate) {
        return !specifications.get(0).isSatisfiedBy(candidate);
    }
    
    public NotSpecification(Specification<T> specification) {
        super(specification);
    }
}
