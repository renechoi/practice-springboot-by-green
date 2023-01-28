package day4.theater;

public interface Dao<T> {
    void insert(T t);
    void select(T t);
}
