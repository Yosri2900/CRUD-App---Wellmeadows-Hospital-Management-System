import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.aot.hint.TypeReference.listOf

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("kapt") version "1.8.22"
}

group = "SEG3102"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-logging")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.2.RELEASE")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	api("org.apache.commons:commons-math3:3.6.1")
	testImplementation("org.junit.platform:junit-platform-suite:1.8.2")
	// This dependency is used internally, and not exposed to consumers on their own compile classpath.
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "mockito-core")
	}

	testImplementation("io.cucumber:cucumber-java8:7.3.3")
	testImplementation("io.cucumber:cucumber-spring:7.3.3")
	testImplementation("io.cucumber:cucumber-junit-platform-engine:7.3.3")
	testImplementation("com.ninja-squad:springmockk:4.0.2")
}

kapt {
	arguments {
		// Set Mapstruct Configuration options here
		// https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
		// https://mapstruct.org/documentation/stable/reference/html/#configuration-options
		// arg("mapstruct.defaultComponentModel", "spring")
	}
	correctErrorTypes = true
}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
