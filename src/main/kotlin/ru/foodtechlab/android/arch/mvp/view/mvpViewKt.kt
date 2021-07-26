package ru.foodtechlab.android.arch.mvp.view

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.renderIf

fun mvpViewKt(
    applicationPackage: String?,
    className: String,
    packageName: String
): String {
    val baseView = renderIf(applicationPackage != null) {
        "import ${applicationPackage}.ui.base.BaseView"
    }
    return """
package ${escapeKotlinIdentifier(packageName)}.${className.toLowerCase()}

$baseView

interface ${className}View : BaseView
"""
}