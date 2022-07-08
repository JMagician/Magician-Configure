<h1> 
    <a href="https://magician-io.com">Magician-Configure</a> ·
    <img src="https://img.shields.io/badge/licenes-MIT-brightgreen.svg"/>
    <img src="https://img.shields.io/badge/jdk-11+-brightgreen.svg"/>
    <img src="https://img.shields.io/badge/maven-3.5.4+-brightgreen.svg"/>
    <img src="https://img.shields.io/badge/release-master-brightgreen.svg"/>
</h1>

Magician-Configure is a configuration manager that can easily read configuration files from external, remote, and local(class resource directories) and cache them in key-value form in the project.

When fetching configuration data, if it is not in the cache, it will automatically go to the environment variables to fetch

## Documentation

[https://magician-io.com](https://magician-io.com)

## Example

### Importing dependencies

```xml
<!-- This is the jar package build by this project -->
<dependency>
    <groupId>com.magician.configure</groupId>
    <artifactId>Magician-Configure</artifactId>
    <version>1.0.0</version>
</dependency>

<!-- This is Magician -->
<dependency>
    <groupId>com.github.yuyenews</groupId>
    <artifactId>Magician</artifactId>
    <version>2.0.5</version>
</dependency>

<!-- This is the log package, which supports any package that can be bridged with slf4j -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-jdk14</artifactId>
    <version>1.7.12</version>
</dependency>
```

### Loading configuration data

Load from external

```java
// The absolute path to the file on the local machine
MagicianConfigure.load("/home/xxx/application.map", ReadMode.EXTERNAL);
```

Load from remote

```java
// The path to the file under the class resource
MagicianConfigure.load("/application.map", ReadMode.LOCAL);
```

Load from local

```java
// Remote path to file, HTTP only
MagicianConfigure.load("https://www.test.com/application.map", ReadMode.REMOTE);
```

### Get the configured value based on key

```java
// If it is not in the configuration file, it will automatically take the environment variables
String userName = Environment.get("JAVA_HOME");
```