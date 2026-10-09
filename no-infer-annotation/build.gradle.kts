import groovy.lang.Closure

plugins {
    `java-library`

    // Version
    id("com.palantir.git-version") version "5.1.0"

    // Maven
    `maven-publish`
    signing
    id("com.vanniktech.maven.publish") version "0.37.0"
}

@Suppress("UNCHECKED_CAST")
val gitVersion = extra.get("gitVersion") as Closure<String>
try {
    version = project.findProperty("version") ?: gitVersion()
    println("Current Version: $version")
} catch (e: Exception) {
    logger.error("Failed to get version from git")
    e.printStackTrace()
}

repositories {
    mavenCentral()
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates("cn.elytra", "no-infer", "${project.version}".removePrefix("v"))
    pom {
        name = "NoInfer Annotation"
        description = "@NoInfer annotation for NoInfer IDEA plugin."
        inceptionYear = "2026"
        url = "https://github.com/ElytraServers/no-infer"
        licenses {
            license {
                name = "MIT"
                url = "https://github.com/ElytraServers/no-infer/blob/master/LICENSE"
            }
        }
        developers {
            developer {
                id = "taskeren"
                name = "Taskeren"
                url = "https://github.com/Taskeren"
            }
        }
        scm {
            url = "https://github.com/ElytraServers/no-infer"
            connection = "scm:git:git://github.com/ElytraServers/no-infer.git"
            developerConnection = "scm:git:ssh://github.com/ElytraServers/no-infer.git"
        }
    }
}
