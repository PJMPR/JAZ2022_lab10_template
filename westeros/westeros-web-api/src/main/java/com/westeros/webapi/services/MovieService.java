package com.westeros.webapi.services;

import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
