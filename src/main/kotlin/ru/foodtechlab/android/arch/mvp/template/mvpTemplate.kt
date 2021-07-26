package ru.foodtechlab.android.arch.mvp.template

import com.android.tools.idea.wizard.template.*
import ru.foodtechlab.android.arch.mvp.recipe.mvpRecipe

val mvpTemplate
    get() = template {
        revision = 1
        name = "FTL Base MVP Structure"
        description = "Create MVP file structure in project"
        minApi = 21
        minBuildApi = 21
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry
        )

        val className = stringParameter {
            name = "MVP Entity Name"
            default = "FoodTechLab"
            help = "Name entity for folder, fragment, presenter and view"
            constraints = listOf(Constraint.CLASS, Constraint.NONEMPTY, Constraint.UNIQUE)
        }

        val layoutName = stringParameter {
            name = "Name Layout"
            default = "fragment_foodtech_lab"
            help = "The name of the layout to create"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY, Constraint.UNIQUE)
            suggest = { fragmentToLayout(className.value) }
        }

        widgets(
            TextFieldWidget(className),
            TextFieldWidget(layoutName)
        )

        recipe = { data: TemplateData ->
            mvpRecipe(data as ModuleTemplateData, className.value, layoutName.value)
        }
    }