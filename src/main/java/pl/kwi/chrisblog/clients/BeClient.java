package pl.kwi.chrisblog.clients;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface BeClient {

    @GetExchange("/message/{id}")
    String findById(@PathVariable("id") Long id);

}