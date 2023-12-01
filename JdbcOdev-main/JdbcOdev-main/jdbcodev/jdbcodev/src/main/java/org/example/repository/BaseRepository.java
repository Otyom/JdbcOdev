package org.example.repository;


    public interface BaseRepository<T> {
        public boolean create(T t);
        public boolean delete(T t);

}
