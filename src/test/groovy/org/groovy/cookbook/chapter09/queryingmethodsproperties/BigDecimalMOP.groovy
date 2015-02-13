package org.groovy.cookbook.chapter09.queryingmethodsproperties

import spock.lang.Specification

import java.text.NumberFormat

class BigDecimalMOP extends Specification {

    def "Should return the result in euro"(){
        given:
        BigDecimal.metaClass.getInEuros = { ->
            def exchangeRate = 0.74
            def nf = NumberFormat.getCurrencyInstance(Locale.UK)
            nf.setCurrency(Currency.getInstance('EUR'))
            nf.format(delegate * exchangeRate)
        }

        when:
        String euros = 1000.00.inEuros

        then:
        '€740.00' == euros
    }
}
