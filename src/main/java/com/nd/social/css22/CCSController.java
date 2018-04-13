package com.nd.social.css22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by quanzongwei(207127) on 2018/4/11 0011.
 */
@RestController
@RequestMapping("/ccs")
@SessionAttributes
public class CCSController {

    @Autowired
    ForexServiceProxy proxy;

    /**
     * jdbc:h2:mem:testdb
     * localhost:8000/h2-console/
     */
    @RequestMapping(value = "/from/{from}/to/{to}/amount/{amount}", method = RequestMethod.GET)
    public Map hello(@PathVariable String from, @PathVariable String to, @PathVariable int amount) {
        Map<String, String> uriMap = new HashMap<String, String>();
        uriMap.put("from", "USD");
        uriMap.put("to", "INR");
        // Map forObject = new RestTemplate().getForObject("http://localhost:8000/forex/f/{from}/t/{to}", Map.class,
        // uriMap );
        // forObject.put("total_amount", bd.multiply(BigDecimal.valueOf(amount)));
        //
        Map<String, Object> mapFromFeign = proxy.getCurrencyConversionInfo(from, to);
        BigDecimal bd = new BigDecimal(String.valueOf(mapFromFeign.get("conversionMultiple")));
        System.out.println(mapFromFeign);
        //
        mapFromFeign.put("total_amount", bd.multiply(BigDecimal.valueOf(amount)));

        return mapFromFeign;
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("100.0"));
    }
}
