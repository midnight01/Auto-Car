import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

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
  getSpecificationID(specificationId: any): Observable<any> {
    return this.http.get(this.API + '/Specification/' + specificationId);
  }

}
