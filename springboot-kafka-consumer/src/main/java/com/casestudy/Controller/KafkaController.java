package com.casestudy.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class KafkaController {
@GetMapping("/display")
public String display() {
	return "In the consumer";
}
}
