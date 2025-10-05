package com.Firstspring.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@OpenAPIDefinition(
        info=@Info(
                title=" Product Service REST API documentation",
                description="Product service REST API",
                version="v1",
                contact=@Contact(
                        name = "Anmol Pandey",
                        email = "anmolpandeyntw@gmail.com"
                )
        ),externalDocs = @ExternalDocumentation(
                description = "Sharepoint URL product service API ",
        url="anmolpandey.com"

)
)




@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class,args);



	}

}
