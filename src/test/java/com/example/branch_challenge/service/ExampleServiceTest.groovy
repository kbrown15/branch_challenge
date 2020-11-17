import com.example.branch_challenge.delegate.ExampleDelegate
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
        1 * exampleDelegate.getMainObject(username)
        1 * exampleDelegate.getRepoObject(userName)

        and:
        noExceptionThrown()
    }

//    def 'Service concats the two API objects together'() {
//        given:
//        String username = 'some_userName'
//        def resp
//
//        when:
//        resp = exampleService.getResponse(username)
//
//        then:
//        1 * exampleDelegate.getMainObject(username) >> new APIObject(user_name: username)
//        1 * exampleDelegate.getRepoObject(userName) >> new APIRepo(name: username)
//
//        //and:
//        //resp = new ResponseObject(user_name: username, repos: [name: username])
//    }
}