plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":business"))
    implementation(project(":database"))
    implementation(project(":webservice"))
}

tasks {
    bootJar {
        archiveFileName.set("${project.parent?.name}.${archiveExtension.get()}")
    }
}
