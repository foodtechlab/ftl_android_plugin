package ru.foodtechlab.android.arch.mvp.recipe

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import ru.foodtechlab.android.arch.mvp.fragment.layout.mvpFragmentXml
import ru.foodtechlab.android.arch.mvp.fragment.src.mvpFragmentKt
import ru.foodtechlab.android.arch.mvp.presenter.mvpPresenterKt
import ru.foodtechlab.android.arch.mvp.view.mvpViewKt
import java.io.File

fun RecipeExecutor.mvpRecipe(
    moduleData: ModuleTemplateData,
    entityName: String,
    layoutName: String
) {
    // Предполагается, что перед созданием mvp сущности уже
    // реализована стандартная структура проекта:
    // имеются base-классы, подключены moxy зависимости и т.п.

    val (projectData, srcOut, resOut, _) = moduleData
    val srcPackage = File("${srcOut.path}/${entityName.toLowerCase()}")
        .apply {
            if (!exists()) {
                mkdir()
            }
        }
    val packageName = moduleData.packageName
    val applicationPackage = moduleData.projectTemplateData.applicationPackage

    // Создание макета
    save(mvpFragmentXml(), resOut.resolve("layout/${layoutName}.xml"))
    open(resOut.resolve("layout/${layoutName}.xml"))

    // Создание класса фрагмента унаследованного от BaseFragment
    val mvpFragment = mvpFragmentKt(applicationPackage, entityName, layoutName, packageName)
    save(mvpFragment, srcPackage.resolve("${entityName}Fragment.kt"))
    open(srcPackage.resolve("${entityName}Fragment.kt"))

    // Создание класса презентера унаследованного от BasePresenter
    val mvpPresenter = mvpPresenterKt(applicationPackage, entityName, packageName)
    save(mvpPresenter, srcPackage.resolve("${entityName}Presenter.kt"))
    open(srcPackage.resolve("${entityName}Presenter.kt"))

    // Создание интерфейса унаследованного от BaseView
    val mvpView = mvpViewKt(applicationPackage, entityName, packageName)
    save(mvpView, srcPackage.resolve("${entityName}View.kt"))
    open(srcPackage.resolve("${entityName}View.kt"))
}
