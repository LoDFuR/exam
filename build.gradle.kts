

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    `java-gradle-plugin`
}

repositories {
    // Use Maven Central for resolving dependencies
    mavenCentral()
}

dependencies {
    // Use JUnit test framework for unit tests
//val junitBomVersion = "5.10.1"
 testImplementation("org.assertj:assertj-core:3.25.1")
    testImplementation("org.junit:junit-bom:5.10.1")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}



