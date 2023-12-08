[info]: img/icons8-info.png
[todo]: img/icons8-zahnrad.png
[2.0-1]: img/2.0-1-create-test.png

![info] Learn [how to use](HOWTO.md) this project

----

### 2.0 - Writing unit tests with JUnit 5

![todo] First you have to learn [what **Test Driven Development (TDD)** means](https://www.jamesshore.com/Agile-Book/test_driven_development.html) and further how to use the [JUnit 5 Framework](https://junit.org/junit5/docs/current/user-guide/).

1. Add the JUnit artifact to your `pom.xml` in scope `test`
   ````
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.6.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
   ````
1. Open class `Startup`, right click on class name and select `Go To > Test > Create New Test...` with these options 
   ![2.0-1]
1. TDD follows the procedure to write tests using functionality, that has yet to be coded. So first write a test that fails or even does not compile. Then modify the production code until it compiles and succeeds.

   So let's add a method `formatArguments` to class `Startup` that formats the given arguments for output. Start by writing a test:
   
   ````
    class StartupTest {
        private static final String OUT_WITHOUT_ARGS = "without arguments";
        private static final String OUT_WITH_ARGS = "with arguments: ";
    
        Startup startup;
    
        @BeforeEach
        void setUp() {
            startup = new Startup();
        }
    
        @AfterEach
        void tearDown() {
        }
    
        @Test
        void formatArgumentsWithOneArg() {
            String arg = "Hello";
            String result = startup.formatArguments(new String[]{arg});
            assertEquals(OUT_WITH_ARGS + "[" + arg + "]", result);
        }
    }
   ````
   Now follow the errors and make the code run. Let your IDEs refactoring features help you.
   
1. Now add another test method and try if it succeeds.
   ````
    @Test
    void formatArgumentsWithTwoArgs() {
        String arg1 = "Hello";
        String arg2 = "World!";
        String result = startup.formatArguments(new String[]{arg1, arg2});
        assertEquals(OUT_WITH_ARGS + "[" + arg1 + ", " + arg2 + "]", result);
    }
   ````

1. A test should also take into account boundary and null values, so add further test methods and go on changing the production code until they succeed.
   ````
   @Test
   void formatArgumentsWithoutArgsEmptyArray() {
       ...
   }
   
   @Test
   void formatArgumentsWithoutArgsNull() {
       ...
   }
   ````
   
1. Finally don't forget to integrate the new method into `Startup.main()`.

1. Feel free to add some additional features but don't forget to start writing the test for it.

1. Your tests will run every time the maven phase `test` is executed.