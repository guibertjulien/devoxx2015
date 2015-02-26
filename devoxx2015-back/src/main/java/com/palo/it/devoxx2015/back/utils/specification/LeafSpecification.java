package com.palo.it.devoxx2015.back.utils.specification;

@SuppressWarnings("unchecked")
public abstract class LeafSpecification<T> extends AbstractCompositeSpecification<T> {
    public abstract boolean isSatisfiedBy(T candidate);
}
