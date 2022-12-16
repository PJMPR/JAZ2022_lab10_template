package com.westeros.webapi.controllers;

import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.services.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService movieService;

    @PostMapping
    public ResponseEntity saveMovie(@RequestBody MovieDto movie){
        var id = movieService.saveMovie(movie);
        return ResponseEntity.ok(id);
    }
}
