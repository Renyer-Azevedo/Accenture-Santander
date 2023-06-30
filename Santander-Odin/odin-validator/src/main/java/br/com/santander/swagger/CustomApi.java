package br.com.santander.swagger;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Success and errors file logs",
                        description = "Retrieves both success and error file records..")
        },
        info = @Info(
                title = "Estudo Quarkus",
                version = "1.0.0",
                contact = @Contact(
                        name = "Azevedo,Renyer",
                        url = "https://www.linkedin.com/in/renyer-azevedo/",
                        email = "renyer.almeida.azevedo@gmail.com"),
                license = @License(
                        name = "github",
                        url = "https://github.com/Renyer-Azevedo"
                )
        )
)
public class CustomApi extends Application {
}
