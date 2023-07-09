plugins {
    kotlin("jvm") version "1.6.21" apply false
    id("cc.polyfrost.multi-version.root")
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

preprocess {
    "1.12.2-forge"(11202, "srg") {
        "1.8.9-forge"(10809, "srg", file("versions/1.12.2-1.8.9.txt"))
    }
}
