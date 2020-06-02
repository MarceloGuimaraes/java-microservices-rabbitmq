package com.guimasoftware;


import com.guimasoftware.interfaces.stream.Channels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //@EnableEurekaClient também pode ser utilizado
@EnableBinding(Channels.class)
@SpringBootApplication
public class OrderRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderRequestApplication.class, args);
	}

}
