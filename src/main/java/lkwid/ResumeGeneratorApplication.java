package lkwid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lkwid.config.ProfilePictureProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProfilePictureProperties.class)
public class ResumeGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeGeneratorApplication.class, args);
	}
}
