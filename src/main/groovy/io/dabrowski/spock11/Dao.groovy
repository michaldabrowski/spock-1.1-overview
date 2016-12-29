package io.dabrowski.spock11

interface Dao<T> {
    List<T> fetchEntities();
}
