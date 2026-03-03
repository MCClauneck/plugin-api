# MCEconomy API

Public API contracts for the MCEconomy ecosystem (group `io.github.mcclauneck`, artifact `mceconomy-api`).

## Dependency coordinates

Version: `2026.0.4-1`

### Maven

Add GitHub Packages (with credentials) and dependency:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/MCClauneck/plugin-api</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>

<servers>
  <server>
    <id>github</id>
    <username>${env.GITHUB_ACTOR}</username>
    <password>${env.GITHUB_TOKEN}</password>
  </server>
</servers>

<dependencies>
  <dependency>
    <groupId>io.github.mcclauneck</groupId>
    <artifactId>mceconomy-api</artifactId>
    <version>2026.0.4-1</version>
  </dependency>
</dependencies>
```

### Gradle (Groovy DSL)

```groovy
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/MCClauneck/plugin-api")
        credentials {
            username = System.getenv("GITHUB_ACTOR") ?: System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation "io.github.mcclauneck:mceconomy-api:2026.0.4-1"
}
```

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/MCClauneck/plugin-api")
        credentials {
            username = System.getenv("GITHUB_ACTOR") ?: System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("io.github.mcclauneck:mceconomy-api:2026.0.4-1")
}
```

## Authentication

Artifacts are served via GitHub Packages. Even though this repository is public, consumers must provide a GitHub username and a token with at least the `read:packages` scope (e.g., via `GITHUB_ACTOR`/`GITHUB_USERNAME` and `GITHUB_TOKEN` environment variables) when resolving dependencies.
