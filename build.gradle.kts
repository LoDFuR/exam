

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    `java-gradle-plugin`
	id("java")
id("jacoco")
}

repositories {
    // Use Maven Central for resolving dependencies
    mavenCentral()
}

dependencies {
    // Use JUnit test framework for unit tests
//val junitBomVersion = "5.10.1"
testImplementation("org.assertj:assertj-core:3.25.1")

  constraints {
        api("org.junit:junit-bom:5.10.1")
        //api("org.assertj:assertj-core:3.25.1")
    }
	//testImplementation platform("org.junit:junit-bom:5.10.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
   testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
jacoco {
    toolVersion = "0.8.11"
	reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}
tasks.test {
	useJUnitPlatform()
	 finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
   // dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required = true
        csv.required = true
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
	
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}