package com.edstem.demo.controller;

import com.edstem.demo.contract.SearchRequest;
import com.edstem.demo.contract.SearchResponse;
import com.edstem.demo.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<SearchResponse> binarySearch(@RequestBody SearchRequest searchRequest) {
        SearchResponse searchResponse = searchService.binarySearch(searchRequest);
        return ResponseEntity.ok(searchResponse);
    }
}

