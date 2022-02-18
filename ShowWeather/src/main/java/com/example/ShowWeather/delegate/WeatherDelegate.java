package com.example.ShowWeather.delegate;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDelegate {
    @Autowired
    RestTemplate restTemplate;

    public String  fallbackMethod(String weather){
        return "Fallback response:: le service il est cassé bro comprend po ";
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getWeatherByZipCode(String zipCode)
    {
        System.out.println("Getting Weather details for " + zipCode);

        String response = restTemplate.exchange("http:/weather-service/zipcode/{zipCode}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, zipCode).getBody();

        System.out.println("Response Body " + response);

        return "Weather zipCode -  " + zipCode + " [ Weather Details " + response+" ]";
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getWeatherByCity(String ville)
    {
        System.out.println("Getting Weather details for " + ville);

        String response = restTemplate.exchange("http:/weather-service/ville/{ville}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, ville).getBody();

        System.out.println("Response Body " + response);

        return "Weather city-  " + ville + " [ Weather Details " + response+" ]";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
