package org.groovy.cookbook.chapter09.intercept

import spock.lang.Specification

class InterceptedClassSpec extends Specification {

    def "should the method being intercepted by using proxy"(){
        when:
        useInterceptor(InterceptedClass, PerformanceInterceptor){
            def ic = new InterceptedClass()
            ic.test('a')
            ic.test('b')
            ic.test('c')
        }

        then:
        1 == 1
    }

    def useInterceptor = { Class theClass,
                           Class theInterceptor,
                           Closure theCode ->
        def proxy = ProxyMetaClass.getInstance(theClass)
        def interceptor = theInterceptor.newInstance()
        proxy.interceptor = interceptor
        proxy.use(theCode)
    }
}
