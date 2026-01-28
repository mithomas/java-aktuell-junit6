plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(project(":app"))
    testImplementation(libs.junit5.jupiter)
    testImplementation(libs.kotlinx.coroutines.test)
    testRuntimeOnly(libs.junit5.platform.launcher)
}
