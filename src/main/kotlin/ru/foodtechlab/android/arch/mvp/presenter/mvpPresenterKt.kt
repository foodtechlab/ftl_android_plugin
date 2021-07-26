package ru.foodtechlab.android.arch.mvp.presenter

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.renderIf

fun mvpPresenterKt(
    applicationPackage: String?,
    className: String,
    packageName: String
): String {
    val basePresenter = renderIf(applicationPackage != null) {
        "import ${applicationPackage}.ui.base.BasePresenter"
    }
    return """
package ${escapeKotlinIdentifier(packageName)}.${className.toLowerCase()}

$basePresenter

class ${className}Presenter : BasePresenter<${className}View>() {
    companion object {
        private const val TAG = "${className}Presenter"
    }
}
"""
}