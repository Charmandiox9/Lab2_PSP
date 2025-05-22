package org.example;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class Testeo {

    @Test
    public void verificarDependenciasDeCapas() {
        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
                .importPackages("org.example");

        ArchRule reglaCapa = layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer("UI").definedBy("org.example.ui..")
                .layer("Service").definedBy("org.example.service..")
                .layer("DAO").definedBy("org.example.dao..")

                .whereLayer("UI").mayOnlyAccessLayers("Service")
                .whereLayer("Service").mayOnlyAccessLayers("DAO")
                .whereLayer("DAO").mayNotAccessAnyLayer();

        reglaCapa.check(importedClasses);
    }


    @Test
    public void verificarDependenciasInternasEnUI() {
        JavaClasses clases = new ClassFileImporter().importPackages("org.example.ui..");

        ArchRule regla = noClasses()
                .that().resideInAPackage("org.example.ui..")
                .should().dependOnClassesThat().resideInAnyPackage("org.example.ui..");

        regla.check(clases);
    }

    @Test
    public void verificarDependenciasInternasEnService() {
        JavaClasses clases = new ClassFileImporter().importPackages("org.example.service..");

        ArchRule regla = noClasses()
                .that().resideInAPackage("org.example.service..")
                .should().dependOnClassesThat().resideInAnyPackage("org.example.service..");

        regla.check(clases);
    }

    @Test
    public void verificarDependenciasInternasEnDAO() {
        JavaClasses clases = new ClassFileImporter().importPackages("org.example.dao..");

        ArchRule regla = noClasses()
                .that().resideInAPackage("org.example.dao..")
                .should().dependOnClassesThat().resideInAnyPackage("org.example.dao..");

        regla.check(clases);
    }
}
