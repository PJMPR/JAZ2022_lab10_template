package com.westeros.webapi.services;

import com.westeros.webapi.contract.MovieDto;

public interface IMovieService {

    long saveMovie(MovieDto dto);
}
