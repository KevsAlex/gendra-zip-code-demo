import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("idea")
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.gendra"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	//Spring dependencies
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation (group= "org.springframework.cloud", name= "spring-cloud-starter-config", version= "2.0.1.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	//SAN GOOGLE 
	implementation("com.google.firebase:firebase-admin:7.1.0")

	//Otras
	implementation("io.springfox:springfox-swagger2:2.8.0")
	implementation("io.springfox:springfox-swagger-ui:2.8.0")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	testImplementation("org.springframework.boot:spring-boot-starter-test")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//EXCLUDE
configurations.forEach {configuration ->
	//configuration.exclude("org.springframework.boot", "spring-boot-starter-logging")
}
