package br.com.desafiocrosscommerce.controller;

import br.com.desafiocrosscommerce.dto.NumbersResponse;
import br.com.desafiocrosscommerce.fetch.FeignClientFetcher;
import br.com.desafiocrosscommerce.integration.http.FeignClientApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class SortedNumbersController {


    @Autowired
    FeignClientApi feignClientApi;

    @GetMapping
    NumbersResponse getNumbersFromApi() {
        int i = 1;
        NumbersResponse numbersResponseAux = new NumbersResponse();
        numbersResponseAux = feignClientApi.getNumbersApi(i);
        NumbersResponse numbersResponse = new NumbersResponse();
        while (numbersResponseAux.getNumbers().size() > 0) {
            numbersResponse.setNumbers(numbersResponseAux.getNumbers());
            numbersResponseAux = feignClientApi.getNumbersApi(i);
            i++;
        }

        //numbersResponse.setNumbers(feignClientApi.getNumbersApi());
        return numbersResponse;
    }
}
