package pl.kwi.chrisblog.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import pl.kwi.chrisblog.clients.BeClient;

@Configuration
public class RestClientConfig {

    @Value("${api.url}")
    private String apiUrl;

    @Bean
    public BeClient beClient(RestClient.Builder restClientBuilder) {

        RestClient restClient = restClientBuilder
                .baseUrl(apiUrl)
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(BeClient.class);

    }

}