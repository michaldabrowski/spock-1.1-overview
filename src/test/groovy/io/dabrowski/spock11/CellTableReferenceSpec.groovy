package io.dabrowski.spock11

import spock.lang.Specification
import spock.lang.Unroll

class CellTableReferenceSpec extends Specification {

    @Unroll
    def 'cells in a data table can refer to the current value for a column to the left'() {
        expect:
            value * multiplier == multipliedValue
        where:
            value | multiplier | multipliedValue
            2     | 2          | value * multiplier
            2     | 3          | value * multiplier
            2     | 4          | value * multiplier
    }
}