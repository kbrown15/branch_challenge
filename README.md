# branch_challenge
Coding exercise submission for Branch

How to Run the API Locally:

1. If you haven't already, clone this repository to your computer
2. In the main project directory, type "./gradlew clean build". This will remove any previous version
of the app you've got cached and build a fresh version
3. Once the service has built, you can run it with "./gradlew bootRun"
4. Open your favorite browser and head over to http://localhost:8080/users/octocat
5. Viola, there's your result! You can also change "octocat" to any other possible username,
but you'll get an error if the user doesn't exist (just so you know)
6. To stop running the service, click Ctrl + C

How to Run the Tests Locally:

If you have Gradle version 6.3 or later installed locally:
1. In the project directory, type "gradle test"

If you do NOT have a compatible version of gradle installed locally:
1. Run the tests through Intellij by importing the service as a module
2. Go to Preferences > Build, Execution, Deployment > Gradle
and set the Run tests using dropdown to Intellij IDEA
3. Run the test by right clicking the src/test/groovy directory and selecting "Run 'All Tests'"

Some Decision Overview:

The application code is organized to separate the controller, service, and repository
(or in this case, the delegate that calls the third-party API)

The tests are organized similarly and intended to present the happy-paths first, then the
possible edge-cases that I thought of on the fly

The controller is intended mostly just to send the url path information to the service, which
handles calling the needed APIs in the correct order and making sure the information returned is
mapped with the correct keys.

I combined the 2 API calls into one response by using multiple POJOs,
which can be found in the models directory. One object is for organizing the /repos response, and 
another object (APIObject) stores the response from /{username}. I tried to use the jackson library's
@JsonProperty annotation to avoid having another object that converts the keys to the response this application
returns, but I wasn't super familiar with it and gave up after 10 minutes in the interest of time.

Another aspect of the code is the logging included throughout, mostly for debugging purposes.
In hind sight, I probably could have forgone the logging and spent that time on more accurate error handling,
ensuring the endpoint was able to return more-specific http codes (besides 404) when something went wrong or the delegate
got a response that we didn't want or expect, but logging is the first step to finding where your code failed you,
so I'm glad I at least did that.

Tests were written in groovy because I like how readable it is, and I have more recent familiarity with it over pure jUnit
testing. The application code was written with test-driven design in mind, and null object returns are allowed just because
that's what I decided I wanted the code to do as I wrote the tests.