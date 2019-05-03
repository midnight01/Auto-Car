import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CarService } from 'src/app/shared/car/car.service';
import { Subscription } from 'rxjs';
import { Carloan } from 'src/app/shared/models/model-class';
import { AngularFireDatabase, AngularFireList } from '@angular/fire/database';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


export interface Installment {
  Number: string;
}

@Component({
  selector: 'app-cc',
  templateUrl: './cc.component.html',
  styleUrls: ['./cc.component.css']
})
export class CcComponent implements OnInit {
  specificationId: any;
  Specification: any;
  sub: Subscription;
  brand: any;
  generation: any;
  items: Observable<any[]>;


  carloan: Carloan = new Carloan();
  numberInstallments: Installment[] = [
    { Number: '12 งวด (1 ปี)' },
    { Number: '24 งวด (2 ปี)' },
    { Number: '36 งวด (3 ปี)' },
    { Number: '48 งวด (4 ปี)' },
    { Number: '60 งวด (5 ปี)' },
    { Number: '72 งวด (6 ปี)' }
  ];

  constructor(db: AngularFireDatabase, private httpClient: HttpClient, private service: CarService, private router: Router, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.specificationId = params['id'];
    });
    this.route.params.subscribe(params => {
      this.brand = params['brand'];
    });
    // console.log(this.brand)
    this.route.params.subscribe(params => {
      this.generation = params['generation'];
    });
    this.items = db.list('image/' + this.brand + '/' + this.generation).valueChanges();
  }

  ngOnInit() {
    this.sub = this.service.getSpecificationID(this.specificationId).subscribe((res) => {
      this.Specification = res;
    });
  }
  Financing: any;
  ber: number;
  interest: any;
  year: any;
  interestyear: any;
  realpaid: any;
  payment: any;
  deposit: any;
  save(price: number) {
    // console.log(this.carloan.numberInstallment)
    if (this.carloan.numberInstallment == '12 งวด (1 ปี)') {
      this.ber = 12
      this.year = 1
    } else if (this.carloan.numberInstallment == '24 งวด (2 ปี)') {
      this.ber = 24
      this.year = 2
    } else if (this.carloan.numberInstallment == '36 งวด (3 ปี)') {
      this.ber = 36
      this.year = 3
    } else if (this.carloan.numberInstallment == '48 งวด (4 ปี)') {
      this.ber = 48
      this.year = 4
    } else if (this.carloan.numberInstallment == '60 งวด (5 ปี)') {
      this.ber = 60
      this.year = 5
    } else if (this.carloan.numberInstallment == '72 งวด (6 ปี)') {
      this.ber = 72
      this.year = 6
    }
    this.deposit = price / Number(this.carloan.deposit);
    this.Financing = price - (price / Number(this.carloan.deposit));
    this.interest = (this.Financing * this.carloan.interest) / 100;
    this.interestyear = this.interest * this.year;
    this.realpaid = this.interestyear + this.Financing;
    this.payment = this.realpaid / this.ber;
  }

  goCustomer(gearSystem:any) {
    // console.log(this.carloan.numberInstallment)
    this.httpClient.post('//localhost:8080/data/Carloan/save/' + this.deposit + '/' + this.Financing + '/' + this.payment + '/' + this.specificationId,
      this.carloan)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Rrror', error);
        }
      );
    this.router.navigate(['/carloan', this.ber, this.payment, this.Financing, this.specificationId, gearSystem]);
  }

  cc:any;
  img(img: any) {
    // if()
    // console.log(this.Specification.image);
    this.cc = img;
    // console.log(img)
  }

}
