package org.example.repository;

public interface BaseRepostory {
    public interface BaseRepository<T> {
        public void create(T t);
    }
}
