package com.westeros.webapi.services;

import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final ICatalogData db;
    @Override
    public long saveMovie(MovieDto dto) {

        var movieEntity = new Movie();
        movieEntity.setRuntime(dto.getRuntime());
        movieEntity.setOverview(dto.getOverview());
        movieEntity.setReleaseDate(dto.getReleaseDate());
        movieEntity.setBudget(dto.getBudget());
        movieEntity.setOriginalTitle(dto.getTitle());
        movieEntity.setHomepage(dto.getHomepage());
        movieEntity.setOriginalLanguage(dto.getLanguage());
        db.getMovies().save(movieEntity);
        return movieEntity.getId();
    }

    @Override
    public List<MovieSummaryDto> getAllMovies() {
        return db.getMovies().findAll().stream().map(movie-> getMovieSummaryDto(movie)).toList();
    }

    private MovieSummaryDto getMovieSummaryDto(Movie movie) {
        var dto = new MovieSummaryDto();
        dto.setId(movie.getId());
        dto.setLanguage(movie.getOriginalLanguage());
        dto.setTitle(movie.getOriginalTitle());
        dto.setHomepage(movie.getHomepage());
        return dto;
    }

}
