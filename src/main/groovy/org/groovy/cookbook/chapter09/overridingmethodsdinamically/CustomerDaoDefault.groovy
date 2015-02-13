package org.groovy.cookbook.chapter09.overridingmethodsdinamically

class CustomerDaoDefault implements CustomerDao {
    @Override
    Customer getCustomerById(Long id) {
        return new Customer(name: 'test')
    }
}
