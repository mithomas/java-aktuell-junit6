plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(project(":app"))
    testImplementation(libs.junit6.jupiter)
    testImplementation(libs.kotlin.reflect)
    testImplementation(libs.kotlinx.coroutines.test)
    testRuntimeOnly(libs.junit6.platform.launcher)
}
