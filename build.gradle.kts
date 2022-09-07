import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.11"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("org.openapi.generator") version "6.0.1"
}

group = "test.fibonacci"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
  	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  	implementation("org.springframework.boot:spring-boot-starter-web")
  	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  	implementation("org.jetbrains.kotlin:kotlin-reflect")
  	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  	testImplementation("org.springframework.boot:spring-boot-starter-test")
 	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}