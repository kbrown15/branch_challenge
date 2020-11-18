import com.example.branch_challenge.delegate.ExampleDelegate
import com.example.branch_challenge.model.APIObject
import com.example.branch_challenge.model.APIRepo
import com.example.branch_challenge.service.ExampleService
import spock.lang.Specification
import spock.lang.Subject

class ExampleServiceTest extends Specification {
    @Subject
    ExampleService exampleService
    ExampleDelegate exampleDelegate

    def setup() {
        exampleDelegate = Mock(ExampleDelegate)
        exampleService = new ExampleService(exampleDelegate)
    }

    def 'Service makes the correct delegate calls on getResponse call'() {
        given:
        String username = 'some_userName'

        when:
        exampleService.getResponse(username)

        then:
        1 * exampleDelegate.getMainObject(username) >> new APIObject()
        1 * exampleDelegate.getRepoObject(username)

        and:
        noExceptionThrown()
    }

    def 'Service combines the two API objects together'() {
        given:
        String username = 'some_username'
        String displayName = 'display_name'
        def avatar = new URL('http://this.is.a.url.com')
        String geoLocation = 'someplace, USA'
        String email = 'someone@email.com'
        def url = new URL('http://this.is.another.url.com')
        def createdAt = new Date()
        def repo_url = new URL('http://this.is.a.repo.url.com')

        //mock response objects
        def apiObject = new APIObject(user_name: username, display_name: displayName, avatar: avatar,
                                    geo_location: geoLocation, email: email, url: url, created_at: createdAt)
        def apiRepo = new APIRepo(name: username, url: repo_url)

        def resp

        when:
        resp = exampleService.getResponse(username)

        then:
        1 * exampleDelegate.getMainObject(username) >> apiObject
        1 * exampleDelegate.getRepoObject(username) >> apiRepo

        and:
        assert resp.user_name ==  username
        assert resp.display_name == displayName
        assert resp.avatar == avatar
        assert resp.geo_location == geoLocation
        assert resp.email == email
        assert resp.url == url
        assert resp.created_at == createdAt
        assert resp.repos[0].name == username
        assert resp.repos[0].url == repo_url
    }

    def 'If first call is null, the second call is not made, and an empty object is returned'() {
        given:
        String username = 'some_userName'
        def resp

        when:
        resp = exampleService.getResponse(username)

        then:
        1 * exampleDelegate.getMainObject(username) >> null
        0 * exampleDelegate.getRepoObject(username)

        and:
        assert resp != null
        assert resp.user_name == null
        assert resp.repos == null
    }

    def 'If the second call is null only the repo is null'() {
        given:
        String username = 'some_userName'
        def resp

        when:
        resp = exampleService.getResponse(username)

        then:
        1 * exampleDelegate.getMainObject(username) >> new APIObject(user_name: username)
        1 * exampleDelegate.getRepoObject(username) >> null

        and:
        assert resp != null
        assert resp.user_name == username
        assert resp.repos == null
    }

    def 'There must be a username passed'() {
        when:
        exampleService.getResponse()

        then:
        thrown(IllegalArgumentException)
    }
}