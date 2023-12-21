package com.edstem.demo.service;

import com.edstem.demo.contract.SearchRequest;
import com.edstem.demo.contract.SearchResponse;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    public SearchResponse binarySearch(SearchRequest searchRequest) {
        long startTime = System.nanoTime();

        int[] array = searchRequest.getArray();
        int target = searchRequest.getTarget();
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                index = mid;
                break;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setIndex(index);
        searchResponse.setTimeTaken(timeTaken);

        return searchResponse;
    }
}





