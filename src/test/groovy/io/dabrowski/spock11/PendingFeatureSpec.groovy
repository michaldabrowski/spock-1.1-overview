package io.dabrowski.spock11

import spock.lang.PendingFeature
import spock.lang.Specification

class PendingFeatureSpec extends Specification {

    UserDao sut = new UserDao()

    @PendingFeature
    def 'should fetch users'() {
        expect:
            sut.fetchEntities() == [new User(name: 'spock')]
    }
}