package com.casestudy.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.casestudy.Models.AuthorReference;


@FeignClient("Author-Project")
public interface AuthorServiceClient {

	@GetMapping("/author/getauthorid/{aid}")
	Optional<AuthorReference> getAuthorByID(@PathVariable int aid);
}
