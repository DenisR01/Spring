package csie.ase.ro.mpai.proiect.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}
