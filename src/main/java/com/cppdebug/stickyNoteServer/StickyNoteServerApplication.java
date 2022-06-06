package com.cppdebug.stickyNoteServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cppdebug.stickyNoteServer.mapper")
@SpringBootApplication
public class StickyNoteServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StickyNoteServerApplication.class, args);
	}

}
