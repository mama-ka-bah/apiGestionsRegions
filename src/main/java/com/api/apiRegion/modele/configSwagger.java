package com.api.apiRegion.modele;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class configSwagger {
    //LA METHODE DOKER PERMET DE GERER TOUTES LES CONFIGURATIONS
    /**
     * L'annotation   @Configuration  appliquée à la classe permet de remplacer un fichier de configuration classique en XML.
     * On commence alors par initialiser un objet Docket en précisant que nous souhaitons utiliser Swagger 2.
     *
     * select permet d'initialiser une classe du nom de ApiSelectorBuilder qui donne accès aux méthodes de
     * personnalisation suivantes. Ne vous attardez pas sur cette méthode,
     * elle n'est d'aucune utilité pour la suite.
     *
     * apis est la première méthode importante. Elle permet de filtrer la documentation à exposer
     * selon les contrôleurs. Ainsi, vous pouvez cacher la documentation
     * d'une partie privée ou interne de votre API. Dans ce cas,
     * nous avons utilisé RequestHandlerSelectors.any().
     *
     * paths : cette méthode donne accès à une autre façon de filtrer :
     * selon l'URI des requêtes. Ainsi, vous pouvez, par exemple,
     * demander à Swagger de ne documenter que les méthodes qui
     * répondent à des requêtes commençant par "/public" .
     * */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any()).build().pathMapping("/")
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    // CETTE PERMET DE D'INDIQUER PLUS D'INFORMATION PAR RAPPOR A L'API EN INDIQUANT LE TITRE, LA DESCRIPTION, LA LICENCE ET LA VERSION
    @Bean
    public ApiInfo apiInfo() {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("APPLICATION DE LA GESTION DES REGIONS").version("1.0").license("(C) Copyright dévéloppée par DEMBLE Idrissa & KEITA Mahamadou Apprenants Kalanso 2 | Destinée à Mali Tourisme")
                .description("Cette API permet de gérer l'ensemble des régions d'une agence de tourisme");
        return builder.build();
    }
}