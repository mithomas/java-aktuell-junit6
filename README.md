# JUnit 5 vs JUnit 6 Comparison Project

This multi-module project demonstrates running **JUnit 5** and **JUnit 6** tests side-by-side using **Gradle (Kotlin DSL) and Maven** with the same source code.

## Project Structure

```
junit6/
├── pom.xml                    # Maven parent POM
├── build.gradle.kts           # Gradle Kotlin DSL configuration
├── settings.gradle.kts        # Gradle subprojects
├── gradle/
│   └── libs.versions.toml    # Gradle version catalogue
├── mvnw / mvnw.cmd           # Maven wrapper
├── gradlew / gradlew.bat     # Gradle wrapper
├── app/                      # Shared application code
│   ├── pom.xml
│   ├── build.gradle.kts
│   └── src/main/java/eu/java_aktuell/junit6/App.java
├── junit5-test/              # JUnit 5 test module
│   ├── pom.xml
│   ├── build.gradle.kts
│   └── src/test/java/example/AppTest.java
├── junit6-test/              # JUnit 6 test module
│   ├── pom.xml
│   ├── build.gradle.kts
│   └── src/test/java/example/AppTest.java
└── junit6-cancellation/      # JUnit 6 Cancellation API example
    ├── pom.xml
    ├── build.gradle.kts
    └── src/test/java/eu/java_aktuell/junit6/CancellationApiExample.java
```

## Running Tests

This project supports **Gradle (Kotlin DSL)** and **Maven** build systems.

### Gradle

```bash
./gradlew :junit5-test:test
./gradlew :junit6-test:test
./gradlew clean
```

### Maven

```bash
./mvnw test -pl junit5-test -am
./mvnw test -pl junit6-test -am
./mvnw clean
```

### Running the Cancellation API Example

The `junit6-cancellation` module demonstrates JUnit 6's programmatic test execution with fail-fast cancellation:

```bash
# Gradle
./gradlew :junit6-cancellation:runCancellationExample

# Maven
./mvnw -pl junit6-cancellation compile exec:java
```

## Key Differences Demonstrated

### Application Code
The `app` module contains:
- **Java code**: `App.java` with basic methods (`greet()`, `add()`)
- **Kotlin code**: `CoroutineExample.kt` demonstrating suspend functions for asynchronous operations

### Lifecycle Hooks
Both JUnit 5 and 6 use the same annotations:
- `@BeforeAll` - runs once before all tests
- `@BeforeEach` - runs before each test
- `@AfterEach` - runs after each test
- `@AfterAll` - runs once after all tests

### Assertions
Both versions support:
- `assertEquals()`, `assertNotNull()`, `assertTrue()`, etc.
- `assertAll()` for grouped assertions
- `@DisplayName` for readable test names
- `@Disabled` to skip tests

### Version-Specific Features
- **JUnit 5** (5.10.0): Mature, stable API with extensive ecosystem support
- **JUnit 6** (6.0.2): Maintains backward compatibility while introducing new capabilities

## Adding New Tests

### To junit5-test
Add tests to `junit5-test/src/test/java/example/`

### To junit6-test
Add tests to `junit6-test/src/test/java/example/`

Both test modules depend on the `app` module (`eu.java_aktuell.junit6.App`) to ensure tests are comparing identical functionality.

## Requirements

- Java 21 or higher
- Gradle 8.11+ (uses wrapper: `./gradlew`) with Kotlin DSL OR
- Maven 3.9+ (uses wrapper: `./mvnw`)

## Dependency Management

### Gradle Version Catalogue
Gradle dependencies are centralized in `gradle/libs.versions.toml`:
- **JUnit 5**: 5.10.0 (platform: 1.10.0) - accessed via `libs.junit5.*`
- **JUnit 6**: 6.0.2 - accessed via `libs.junit6.*`

Each module references its appropriate version using type-safe accessors.

### Maven Properties
Maven dependencies use properties defined in each module's `pom.xml`:
- **junit5-test**: `junit.version` and `junit.platform.version`
- **junit6-test**: `junit.version`

## Build Output Directories

- **Gradle**: `build/` (in each module)
- **Maven**: `target/` (in each module)
- Both are in `.gitignore`

## Notes

- Tests output lifecycle information to show execution order
- `--parallel` (Gradle) or `-T 2` (Maven) enables concurrent execution
- **Gradle** reports: `build/reports/tests/test/index.html`
- **Maven** reports: `target/surefire-reports/`
