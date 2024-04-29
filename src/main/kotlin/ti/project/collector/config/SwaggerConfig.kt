package ti.project.collector.config

import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
    }

    @Bean
    fun apiInfo(): ApiInfo? {
        val builder = ApiInfoBuilder()
        builder.title(ti.project.collector.Application.NAME)
            .version(ti.project.collector.Application.VERSION)
            .license("(C) Copyright IB.Team")
            .description("<br/>List of all the APIs of **" + ti.project.collector.Application.SERVICE_NAME + "** App through Swagger UI")
        return builder.build()
    }
}