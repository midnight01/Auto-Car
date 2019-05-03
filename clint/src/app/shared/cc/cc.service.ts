import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CcService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  public API = '//localhost:8080/data';

  constructor(private http: HttpClient) {
  }
  getSpecification(): Observable<any> {
    return this.http.get(this.API + '/Specification');
  }
}
