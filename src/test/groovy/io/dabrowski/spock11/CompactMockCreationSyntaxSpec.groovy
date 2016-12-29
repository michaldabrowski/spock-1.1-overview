package io.dabrowski.spock11

import spock.lang.See
import spock.lang.Specification

@See('https://solidsoft.wordpress.com/2016/11/28/more-compact-mock-creation-syntax-in-spock-1-1/')
class CompactMockCreationSyntaxSpec extends Specification {

    def 'no warning in IDE'() {
        when:
            Dao<User> dao = Stub()
        then:
            dao != null
    }
}
