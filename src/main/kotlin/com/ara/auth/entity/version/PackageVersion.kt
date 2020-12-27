package com.ara.auth.entity.version

object PackageVersion : Version {
    override val major: String?
        get() = getVersion(0)
    override val minor: String?
        get() = getVersion(1)
    override val patch: String?
        get() = getVersion(2)
    override val commit: String?
        get() = javaClass.`package`.implementationVersion

    private fun getVersion(index: Int) = javaClass.`package`.specificationVersion?.split(".")?.getOrNull(index)
}
