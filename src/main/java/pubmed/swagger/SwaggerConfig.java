package pubmed.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameterBuilders = new ArrayList<>(1);
        parameterBuilder
                .name("header")
                .description("Description of header")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true);
        parameterBuilders.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pubmed.controller"))
                .paths(regex("/pubmedservice.*"))
                .build();
    }
}
