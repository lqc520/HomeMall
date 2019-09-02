package cn.lqcnb.mall;
import io.swagger.annotations.ApiOperation;
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
public class Swagger2 {


    /**
     * 如何知道对哪些类生成api 文档呢
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("cn.lqcnb.mall.api")) // 指定对哪些包下的类生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 对有ApiOperation注解的类生成文档
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Mall项目API文档")
                .description("Mall项目API文档，")
                .termsOfServiceUrl("http://mall.lqcnb.cn/")
                .version("1.0")
                .build();
    }
}
