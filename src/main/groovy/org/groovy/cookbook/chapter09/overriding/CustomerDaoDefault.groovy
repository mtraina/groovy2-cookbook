package org.groovy.cookbook.chapter09.overriding

class CustomerDaoDefault implements CustomerDao {
    @Override
    Customer getCustomerById(Long id) {
        return new Customer(name: 'test')
    }
}
