package org.groovy.cookbook.chapter09.overridingmethodsdinamically

class CustomerServiceDefault implements CustomerService {
    CustomerDao customerDao

    CustomerServiceDefault(CustomerDao customerDao){
        this.customerDao = customerDao
    }

    @Override
    Customer getCustomer(Long id) {
        return customerDao.getCustomerById(id)
    }
}
