package ru.foodtechlab.android.arch

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import ru.foodtechlab.android.arch.mvp.template.mvpTemplate

class WizardTemplateProviderImpl  : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(mvpTemplate)
}