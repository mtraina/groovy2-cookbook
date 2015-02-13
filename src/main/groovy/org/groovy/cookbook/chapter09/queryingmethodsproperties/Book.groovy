package org.groovy.cookbook.chapter09.queryingmethodsproperties

class Book {
    String title
    Author author
    Long year
    Long pages

    Long getAmazonSalesPosition(){
        new Random().nextInt(1) + 1
    }

    void attachReview(String review){}
}
