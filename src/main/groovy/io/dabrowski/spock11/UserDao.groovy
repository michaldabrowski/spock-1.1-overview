package io.dabrowski.spock11

class UserDao implements Dao<User> {
    @Override
    List<User> fetchEntities() {
        throw new RuntimeException('Not implemented yet')
//        return [new User(name: 'spock')]
    }
}
