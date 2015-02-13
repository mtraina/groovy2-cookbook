package org.groovy.cookbook.chapter09.querying

import spock.lang.Specification

class BookSpec extends Specification {

    def "Should get the expected properties"() {
        given:
        Author a = new Author(name: 'Ernest', lastName: 'Hemingway')
        Book book = new Book()
        book.with {
            title = 'The Old Man and the Sea'
            year = 1952
            pages = 200
            author = a
        }

        when:
        book.properties.each{println it}
        println '### METHODS ###'
        book.metaClass.methods.each{println it}
        println '### PROPERTIES ###'
        book.metaClass.properties.each{println it.name}

        then:
        book.metaClass.hasProperty(book, 'pages')

        then:
        book.metaClass.respondsTo(book, 'getAmazonSalesPosition')
        book.respondsTo('attachReview', String)
    }
}
