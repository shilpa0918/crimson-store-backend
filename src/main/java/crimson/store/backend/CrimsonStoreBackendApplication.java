package crimson.store.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrimsonStoreBackendApplication {

	public static void main(String[] args) {
		String str = "abc;abc;abc";
		String abc =str;
		System.out.println(abc);
		SpringApplication.run(CrimsonStoreBackendApplication.class, args);
	}

}