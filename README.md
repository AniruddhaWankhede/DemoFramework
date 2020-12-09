# DemoFramework
This Automation framework supports Web and API automation. It is a POM based structure which contains different utitilies to perform various activities.
Below highlighted points that included in this framework:

1. This framework is a Gradle framework where we need to download dependencies for Selenium, TestNG, RestAssured.
2. Test Base class which is used for initial setup.
3. Constant class where all constants are declared.
4. Supports parallel execution with the help of TestNG. Singleton Design pattern used in this case.
5. Different utilities for Assertion, Extent Report management, logs management, screenshot, re-execution of failed tests.
6. Separate package for various WebDrivers. Factory method design pattern used in this case.
7. Extent HTML report as an execution result report.
8. Custom methods for WebDriver actions, Assertions.
9. Log4j used for logging purpose.
10. Use of Property file for passing parameters. Also, provision of passing dynamic parameters with Gradle at Runtime.


Components Required:
1. Java 8 or more
2. GIT
3. Gradle

Execution steps:
1. Clone a github repository as -> URL: https://github.com/AniruddhaWankhede/DemoFramework.git
2. Checkout 'master' branch
3. Download dependencies by entering command 'gradle eclipse' on CMD.
4. Execute gradle task on CMD as 'gradle test "-Dbrowser=Google Chrome" "-Durl=https://github.com/django"'
Note: If you are not passing any parameter, then parameters will be considered from config.properties file.
5. Post execution,Extent Report will get generated under 'build/ExecutionReport.html'