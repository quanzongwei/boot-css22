package com.nd.social.css22;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * Created by quanzongwei(207127) on 2018/4/12 0012.
 */
//@FeignClient(name = "forex-service", url = "http://localhost:8000")
@FeignClient(name = "forexservice")
@RibbonClient(name = "forexservice")
public interface ForexServiceProxy {
    // fuck the value i right and name is wrong todo
    @GetMapping(value = "/forex/f/{from}/t/{to}")
    public Map<String,Object> getCurrencyConversionInfo(@PathVariable("from") String from, @PathVariable("to") String to);
}
