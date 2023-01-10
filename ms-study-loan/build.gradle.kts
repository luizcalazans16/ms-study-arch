

plugins {
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"

	id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
	id("org.springframework.boot") version "2.7.0" apply false

	jacoco
}

allprojects {
	group = "com.study.loan"
	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://packages.confluent.io/maven/") }
	}
}

subprojects {
	apply {
		plugin("kotlin")
		plugin("jacoco")
		plugin("org.jlleitschuh.gradle.ktlint")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}

	java {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	dependencies {
		implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.0"))
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("io.projectreactor:reactor-test")
	}

	tasks {
		compileKotlin {
			kotlinOptions {
				jvmTarget = java.sourceCompatibility.toString()
				freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
			}
		}
		compileTestKotlin {
			kotlinOptions {
				jvmTarget = java.sourceCompatibility.toString()
				freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
			}
		}

		test {
			useJUnitPlatform()
		}
	}
}
