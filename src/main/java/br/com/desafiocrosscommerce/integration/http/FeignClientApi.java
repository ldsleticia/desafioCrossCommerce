package br.com.desafiocrosscommerce.integration.http;

import br.com.desafiocrosscommerce.config.FeignClientConfig;
import br.com.desafiocrosscommerce.dto.NumbersResponse;
import br.com.desafiocrosscommerce.model.Numbers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "numbers",
        url = "http://challenge.dienekes.com.br/api/numbers",
        configuration = { FeignClientConfig.class })
public interface FeignClientApi {
    @RequestMapping(method = RequestMethod.GET, value = "")
    NumbersResponse getNumbersApi(@RequestParam int page);
}
