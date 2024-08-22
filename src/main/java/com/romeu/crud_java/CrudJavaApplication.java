//classe de entrada da minha aplicação, que vai iniciar tudo.
package com.romeu.crud_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 /*Essa anotação faz o spring entender que é classe de entrada*/
@SpringBootApplication
public class CrudJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJavaApplication.class, args);
	}

}
