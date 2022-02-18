package com.example.ShowWeather.controller;

import com.example.ShowWeather.delegate.WeatherDelegate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    WeatherDelegate weatherDelegate;

    @RequestMapping(value = "weatherZipcodeDetails/zipcode/{zipCode}", method = RequestMethod.GET)
    public String getWeatherByZipCode(@PathVariable String zipCode)
    {
       return weatherDelegate.getWeatherByZipCode(zipCode);
    }

    @RequestMapping(value = "weatherVilleDetails/ville/{ville}", method = RequestMethod.GET)
    public String getWeatherByCity(@PathVariable String ville)
    {
       return weatherDelegate.getWeatherByCity(ville);
    }

}
