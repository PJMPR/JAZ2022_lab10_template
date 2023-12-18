import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Router } from '@angular/router';
import {Movie} from "../../contracts/movie";
import { Language } from 'src/app/contracts/language';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movie: Movie = new Movie();
  languages : Language[] = [];
  constructor(private movieService: MovieService,
    private router: Router) { }

  ngOnInit(): void {
    this.movieService.getlanguages()
    .subscribe(data=>this.languages=data);
  }

  saveMovie(){
    this.movieService.createMovie(this.movie).subscribe(data =>{
      console.log(data);
      this.goToMoviesList();
    },
    error => console.log(error));
  }

  goToMoviesList(){
    this.router.navigate(['/movies']);
  }

  onSubmit(){
    console.log(this.movie);
    this.saveMovie();
  }
}
