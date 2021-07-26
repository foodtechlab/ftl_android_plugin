package ru.foodtechlab.android.arch.mvp.fragment.src

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.renderIf

fun mvpFragmentKt(
    applicationPackage: String?,
    className: String,
    layoutName: String,
    packageName: String
): String {
    val applicationResource = renderIf(applicationPackage != null) {
        "import ${applicationPackage}.R"
    }
    val baseFragment = renderIf(applicationPackage != null) {
        "import ${applicationPackage}.ui.base.BaseFragment"
    }
    return """
package ${escapeKotlinIdentifier(packageName)}.${className.toLowerCase()}

import moxy.ktx.moxyPresenter
$baseFragment
$applicationResource

class ${className}Fragment : BaseFragment(R.layout.${layoutName}), ${className}View {

    private val presenter by moxyPresenter { ${className}Presenter() }

    companion object {
        const val TAG = "${className}Fragment"
    }
}
"""
}