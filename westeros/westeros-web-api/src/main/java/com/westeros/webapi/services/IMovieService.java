package com.westeros.webapi.services;

import com.westeros.webapi.contract.LanguageDto;
import com.westeros.webapi.contract.MovieDto;

import java.util.List;

public interface IMovieService {

    long saveMovie(MovieDto dto);
}
