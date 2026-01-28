plugins {
    java
}

// Task to run CancellationApiExample (implicit class)
tasks.register<JavaExec>("runCancellationExample") {
    dependsOn("classes")
    mainClass.set("CancellationApiExample")
    classpath = sourceSets["main"].runtimeClasspath
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(21))
    })
}

dependencies {
    implementation(libs.junit6.jupiter)
    implementation(libs.junit6.platform.launcher)
}
