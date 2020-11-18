package com.example.branch_challenge.controller

import com.example.branch_challenge.service.ExampleService
import spock.lang.Specification
import spock.lang.Subject

class ExampleControllerTest extends Specification {
    @Subject
    ExampleController exampleController
    ExampleService exampleService

    def setup() {
        exampleService = Mock(ExampleService)
        exampleController = new ExampleController(exampleService)
    }

    def 'Controller will call service method'() {
        given:
        String username = 'some_userName'

        when:
        exampleController.getExampleResponse(username)

        then:
        1 * exampleService.getResponse(username)

        and:
        noExceptionThrown()
    }

    def 'Controller can take a null name'() {
        when:
        exampleController.getExampleResponse()

        then:
        1 * exampleService.getResponse(null)

        and:
        noExceptionThrown()
    }
}
