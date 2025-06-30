package com.njabbic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.njabbic.client.OpenLibraryLookupService;

import reactor.core.publisher.Mono;


@Controller
public class BookLookupController {

    @Autowired
    final OpenLibraryLookupService openLibService;

    public BookLookupController(OpenLibraryLookupService openLibraryLookupService){
        this.openLibService=openLibraryLookupService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "PONG";
    }


    @GetMapping("/books/{title}")
    public Mono<String> getBookByTitle(@PathVariable("title") String title) {

        System.out.println("Sending Request with Param " + title);
        return openLibService.findBookByTitle(title);
    }
}
