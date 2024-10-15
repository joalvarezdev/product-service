import org.gradle.kotlin.dsl.*
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("java-library")
  id("org.springframework.boot") version "3.2.1"
  id("io.spring.dependency-management") version "1.1.6"
  id("co.uzzu.dotenv.gradle") version "4.0.0"
}

group = "com.joalvarez"
version = "1.0.0"
description = "product-service"

repositories {
  mavenCentral()
  mavenLocal()

  maven {
    url = uri("https://repo.spring.io/milestone")
  }
}

dependencies {
  // ! INIT
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-actuator")


  // ! DATABASE
  runtimeOnly("org.postgresql:postgresql")

  implementation("org.liquibase:liquibase-core")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  // ! DOCUMENTATION
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

  // ! TEST
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.instancio:instancio-junit:5.0.2")
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
	options.encoding = "UTF-8"
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<BootJar>("bootJar") {
	archiveFileName.set("product-service.jar")
}

tasks.withType<ProcessResources> {
	filesMatching("application.yml") {
		expand(project.properties)
	}
}

tasks.register("printProjectName") {
    doLast {
        println(rootProject.name)
    }
}