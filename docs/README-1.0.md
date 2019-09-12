[info]: img/icons8-info.png
[todo]: img/icons8-zahnrad.png

![info] Learn [how to use](HOWTO.md) this project

----

### 1.0 - Setting up an application as executable jar file - working with the maven project object model (POM)

![todo] First you have to learn [what **maven** is used for](https://maven.apache.org/what-is-maven.html) and [how to use it](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

1. Create a new maven module "execjar" within the project `File > New > Module > Maven (without archetype)`

   ![info] All paths from now on are relative to the new modules root
   
1. Have a look at file `pom.xml`
1. Create a new Class "Startup" within folder `src/main/java` and implement the main method that prints something to `System.out`.
1. Build the module by calling maven goal "package".<br> The project should now [look like this](img/1.0-1-execjar-after-package.png "execjar after maven package")
1. Have a look at directory `target` and list contents of the target jar via  command line tool `jar tf <path to jar>`

   ![todo] Learn more about [JDK Commands](https://docs.oracle.com/javase/10/tools/tools-and-command-reference.htm#JSWOR596)
    
1. Try to launch the packaged target jar via `right-click > Run`
1. Adjust the `pom.xml` and use the [Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/index.html) so that the target jar can be launched and prints the implemented message to console's output.
1. Once again have a look at directory `target` and list contents of the target jar via  command line tool `jar tf <path to jar>`. Take a deeper look at file `META-INF/MANIFEST.MF` via command 

   ![todo] Learn more about [packaging java application within jar files](https://docs.oracle.com/javase/tutorial/deployment/jar/index.html).

1. Eliminate all Warnings from maven output after executing "package" goal 
  * Explicitly define [source file encoding for Resources Plugin](https://maven.apache.org/plugins/maven-resources-plugin/examples/encoding.html).
  * Explicitly define [java source and target version for Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html)