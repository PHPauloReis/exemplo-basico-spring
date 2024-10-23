package br.gov.prodeb.testeapi1.services;

import br.gov.prodeb.testeapi1.http.ViaCepHttpRequest;
import br.gov.prodeb.testeapi1.http.dto.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Service
public class AddressService {

    private static final String PREFIXO_CACHE_CEP = "cep:";

    @Autowired
    private ViaCepHttpRequest viaCepHttpRequest;

    @Autowired
    private RedisTemplate<String, ViaCepResponse> redisTemplate;

    public ViaCepResponse getAddressByCep(String cep) {
        String cacheKey = PREFIXO_CACHE_CEP + cep;

        ViaCepResponse viaCepResponse = redisTemplate.opsForValue().get(cacheKey);

        if (viaCepResponse != null) {
            return viaCepResponse;
        }

        ViaCepResponse addressResponse = viaCepHttpRequest.getCep(cep);
        redisTemplate.opsForValue().set(cacheKey, addressResponse, 1, TimeUnit.HOURS);

        return addressResponse;
    }

}
