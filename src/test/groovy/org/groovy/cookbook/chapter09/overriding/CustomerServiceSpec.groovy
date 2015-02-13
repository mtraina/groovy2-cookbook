package org.groovy.cookbook.chapter09.overriding

import spock.lang.Specification

class CustomerServiceSpec extends Specification {
    def "should get the customer"(){
        given:
        boolean daoCalled = false;
        CustomerDao.metaClass.getCustomerById = { Long id ->
            daoCalled = true
            new Customer(name:'Yoda')
        }

        def cd = new CustomerDaoDefault();
        def cs = new CustomerServiceDefault(cd);

        when:
        def customer = cs.getCustomer(100L)

        then:
        daoCalled
        customer.name == 'Yoda'
    }
}
