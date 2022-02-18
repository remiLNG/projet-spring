package com.example.WeatherService.controller;


import com.example.WeatherService.beans.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {
    public static final List<Weather> weathers = new ArrayList<>(){
        private static final long serialVersionUID = -3970206781360313502L;
        {
            add(new Weather("Marseille","13000","France","Il fait beau"));
            add(new Weather("Nice","06000","France","Il fait grave beau"));
            add(new Weather("Londres","06000","Angleterre","Il fait pas beau"));
        }
    };

    @RequestMapping(name="getWeatherByCity", method= RequestMethod.GET,value="ville/{ville}")
    public List<Weather> getWeatherByCity(@PathVariable String ville){
        try {
            return weathers.stream()
                    .filter(weather -> ville.equals( weather.getVille()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(name="getWeatherByZipCode", method= RequestMethod.GET,value="zipcode/{zipCode}")
    public List<Weather> getWeatherByZipCode(@PathVariable String zipCode){
        try {
            return weathers.stream()
                    .filter(weather -> zipCode.equals( weather.getZipCode()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(name="getWeatherByPays", method= RequestMethod.GET,value="pays/{pays}")
    public List<Weather> getWeatherByPays(@PathVariable String pays){
        try {
            return weathers.stream()
                    .filter(weather -> pays.equals( weather.getPays()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
