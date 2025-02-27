package ru.example.version2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.example.version2.player.Player;
import ru.example.version2.player.UI;

@SpringBootApplication
public class Version2Application {

	public static void main(String[] args) {

		SpringApplication.run(Version2Application.class, args);

	}

}
