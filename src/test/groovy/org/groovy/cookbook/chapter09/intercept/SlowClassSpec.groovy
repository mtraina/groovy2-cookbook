package org.groovy.cookbook.chapter09.intercept

import spock.lang.Specification

class SlowClassSpec extends Specification {

    def "should the method being intercepted"(){
        given:
        SlowClass sc = new SlowClass()

        when:
        (1..3).each {
            sc.test('hello')
        }

        then:
        1 == 1
    }
}
