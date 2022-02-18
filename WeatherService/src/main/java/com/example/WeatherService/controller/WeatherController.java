package com.example.WeatherService.controller;


import com.example.WeatherService.beans.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "WeatherService", description = "Service to retrieve weather")
public class WeatherController {
    public static final List<Weather> weathers = new ArrayList<Weather>(){
        private static final long serialVersionUID = -3970206781360313502L;
        {
            add(new Weather("Marseille","13000","France","Il fait beau"));
            add(new Weather("Nice","06000","France","Il fait grave beau"));
            add(new Weather("Londres","06000","Angleterre","Il fait pas beau"));
        }
    };


    @ApiOperation(value = "Get weather by city", response = Weather.class, tags = "getWeatherByCity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "city not found") })
    @RequestMapping(name="getWeatherByCity", method= RequestMethod.GET,value="/ville/{ville}")
    public List<Weather> getWeatherByCity(@PathVariable String ville){
        try {
            return weathers.stream()
                    .filter(weather -> ville.toUpperCase().equals( weather.getVille().toUpperCase()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get weathers by zipcode", response = Weather.class, tags = "getWeatherByZipCode")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "zipcode not found") })
    @RequestMapping(name="getWeatherByZipCode", method= RequestMethod.GET,value="/zipcode/{zipCode}")
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


    @ApiOperation(value = "Get weathers by country", response = Weather.class, responseContainer = "List", tags = "getWeatherByPays")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "country not found") })
    @RequestMapping(name="getWeatherByPays", method= RequestMethod.GET,value="/pays/{pays}")
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
