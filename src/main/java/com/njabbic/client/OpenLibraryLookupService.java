package com.njabbic.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class OpenLibraryLookupService {

    @Autowired
    private final WebClient openLibClient;

    public OpenLibraryLookupService(@Qualifier("openLibClient") WebClient openLibClient){
        this.openLibClient=openLibClient;
        System.out.println("Injected WebClient with base URL: " + openLibClient);
    }

    public Mono<String> findBookByTitle(String title){
        return openLibClient.get()
                .uri(uriBuilder -> {
                    URI uri = uriBuilder
                        .queryParam("q",title)
                        .build();
                        System.out.println("============== FINAL URI ============= : " + uri.toString());
                        return uri;
                    })
                .header("Accept", "application/json")
                .header("User-Agent", "Spring WebClient")
                .retrieve()
                .bodyToMono(String.class);
    }
}
