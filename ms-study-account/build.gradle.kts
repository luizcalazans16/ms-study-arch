val kotlinLoggingVersion: String by ext
val springCloudVersion: String by ext
val postgresSqlVersion: String by ext
val postgresR2dbcDriverVersion: String by ext

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
    id("org.springframework.boot") version "2.7.0" apply false

    jacoco
}

allprojects {
    group = "com.study.account"
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
        plugin("io.spring.dependency-management")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    configurations.implementation {
        exclude(group = "io.projectreactor.netty", module = "reactor-netty-http-brave")
        exclude(group = "org.springframework.cloud", module = "spring-cloud-sleuth-brave")
    }

    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.0"))
        implementation(platform("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))

        implementation("org.springframework.cloud:spring-cloud-starter-sleuth") {
            exclude(group = "org.springframework.cloud", module = "spring-cloud-sleuth-brave")
        }
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")

        implementation("org.postgresql:postgresql:$postgresSqlVersion")
        implementation("io.r2dbc:r2dbc-postgresql:$postgresR2dbcDriverVersion")

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
