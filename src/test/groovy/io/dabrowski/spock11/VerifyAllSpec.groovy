package io.dabrowski.spock11

import spock.lang.Specification

class VerifyAllSpec extends Specification {

    def 'verify all test'() {
        expect:
            verifyAll {
                assertOneIsOne()
                assertTwoIsTwo()
                assertThreeIsThree()
            }
    }

    private static boolean assertOneIsOne() {
        println 'one is one'
        return 1 == 1
    }

    private static boolean assertTwoIsTwo() {
        println 'two is two'
        return 2 == 2
    }

    private static boolean assertTwoIsTwoBroken() {
        println 'two is two'
        return 2 == 3 // oops
    }

    private static boolean assertThreeIsThree() {
        println 'three is three'
        return 3 == 3
    }
}