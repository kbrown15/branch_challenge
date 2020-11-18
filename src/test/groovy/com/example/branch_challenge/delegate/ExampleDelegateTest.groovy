package com.example.branch_challenge.delegate

import com.example.branch_challenge.model.APIObject
import com.example.branch_challenge.model.APIRepo
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Subject

class ExampleDelegateTest extends Specification{
    @Subject
    ExampleDelegate exampleDelegate
    RestTemplate restTemplate

    def setup() {
        restTemplate = Mock(RestTemplate)
        exampleDelegate = new ExampleDelegate(restTemplate)
    }

    def 'Delegate calls the correct APIs'() {
        given:
        String baseUrl = 'https://api.github.com/users/{username}'
        String repoUrl = 'https://api.github.com/users/{username}/repos'
        String username = 'some_username'

        when:
        exampleDelegate.getMainObject(username)

        then:
        1 * restTemplate.getForObject(baseUrl, APIObject.class, username)

        when:
        exampleDelegate.getRepoObject(username)

        then:
        1 * restTemplate.getForObject(repoUrl, APIRepo[].class, username)

        and:
        noExceptionThrown()
    }

    //This shouldn't ever happen, service checks for username != null
    def 'Delegate calls the correct APIs even with null name'() {
        given:
        String baseUrl = 'https://api.github.com/users/{username}'
        String repoUrl = 'https://api.github.com/users/{username}/repos'
        String username = null

        when:
        exampleDelegate.getMainObject(username)

        then:
        1 * restTemplate.getForObject(baseUrl, APIObject.class, username)

        when:
        exampleDelegate.getRepoObject(username)

        then:
        1 * restTemplate.getForObject(repoUrl, APIRepo[].class, username)

        and:
        noExceptionThrown()
    }
}
