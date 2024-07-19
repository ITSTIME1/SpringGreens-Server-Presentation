plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.spring-greens"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.mysql:mysql-connector-j:8.3.0") // mariadb connector
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive") // redis
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.0") // jpa
//	implementation("org.springframework.boot:spring-boot-starter-security") // security 6.3.1
//	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client") // Oauth2
	implementation("org.springframework.boot:spring-boot-starter-logging")
	implementation("com.fasterxml.jackson.core:jackson-databind") // jackson
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1") // jackson dataType converter
	testImplementation("org.mockito:mockito-junit-jupiter")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
