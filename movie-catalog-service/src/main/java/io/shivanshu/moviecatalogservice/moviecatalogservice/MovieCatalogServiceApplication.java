package io.shivanshu.moviecatalogservice.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {

	/*
		this bean annotation helps us to find single instance of object in whole service.
		so that new instance will not created and data should not change from last state.

		this method will run only once in a time.
		and tell spring this only instance of rest template we have required.

		this method is producer and @Autowired annotation object in  
		Movie Catalog Resource file is the consumer.

		Using @Autowired annotation will fetch instance through all beans and tied up through this method.
	*/
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
