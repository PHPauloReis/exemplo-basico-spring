package br.gov.prodeb.testeapi1.http;

import br.gov.prodeb.testeapi1.http.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepHttpRequest {

    @GetMapping("/{cep}/json")
    ViaCepResponse getCep(@PathVariable String cep);

}
