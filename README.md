# Example Spark-Kotlin-Gradle project 

--- 

##  How to run?

### Tests

```shell
./gradlew test
```

### Job locally

```shell
./gradlew shadowJar
java -XX:+IgnoreUnrecognizedVMOptions \
  --add-opens=java.base/java.lang=ALL-UNNAMED \
  --add-opens=java.base/java.lang.invoke=ALL-UNNAMED \
  --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
  --add-opens=java.base/java.io=ALL-UNNAMED \
  --add-opens=java.base/java.net=ALL-UNNAMED \
  --add-opens=java.base/java.nio=ALL-UNNAMED \
  --add-opens=java.base/java.util=ALL-UNNAMED \
  --add-opens=java.base/java.util.concurrent=ALL-UNNAMED \
  --add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED \
  --add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
  --add-opens=java.base/sun.nio.cs=ALL-UNNAMED \
  --add-opens=java.base/sun.security.action=ALL-UNNAMED \
  --add-opens=java.base/sun.util.calendar=ALL-UNNAMED \
  --add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED \
  -jar build/libs/example-spark-kotlin-gradle-project-1.0-SNAPSHOT-all.jar
```

Those all `--add-opens` are required when using Java 17 (see [JavaModuleOptions](https://github.com/apache/spark/blob/v3.3.0/launcher/src/main/java/org/apache/spark/launcher/JavaModuleOptions.java)).

If you want to use Java 8, you should change `jvmToolchain` version (in [build.gradle.kts](build.gradle.kts)):
```kotlin
kotlin {
    jvmToolchain(8)
}
```

## Sources

- [Kotlin for Apache Spark](https://github.com/Kotlin/kotlin-spark-api)
- [Quick Start Guide](https://github.com/Kotlin/kotlin-spark-api/wiki/Quick-Start-Guide)
- [kotlin-spark-example](https://github.com/MKhalusova/kotlin-spark-example)