import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/app/shared/car/car.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { customer } from 'src/app/shared/models/model-class';
import { HttpClient } from '@angular/common/http';
import { CarloanService } from 'src/app/shared/carloan/carloan.service';




export interface workExperiences {
  work: string;
}

export interface jobStatus {
  Status: string;
}

export interface salaryBases {
  Bases: string;
}

@Component({
  selector: 'app-carloan',
  templateUrl: './carloan.component.html',
  styleUrls: ['./carloan.component.css']
})
export class CarloanComponent implements OnInit {
  specificationId: any;
  Specification: any;
  sub: Subscription;
  ber: any;
  payment: any;
  financing: any;
  gearSystem: any;
  gear: string;
  carloan:any;
  customer: customer = new customer;

  jobStatus: jobStatus[] = [
    { Status: 'ทำงานอยู่' },
    { Status: 'ว่างงาน' }
  ];

  workExperiences: workExperiences[] = [
    { work: 'ไม่ถึงปี' },
    { work: '1 ปี' },
    { work: '2 ปี' },
    { work: '3 ปี' },
    { work: '4 ปี' },
    { work: '5 ปีขึ้นไป' }
  ];
  salaryBases: salaryBases[] = [
    { Bases: '0 - 9,000' },
    { Bases: '10,000 - 30,000' },
    { Bases: '40,000 - 60,000' },
    { Bases: '70,000 - 90,000' },
    { Bases: '100,000 ขึ้นไป' }
  ];

  carloanId:any;
  constructor(private httpClient: HttpClient, private service: CarService, private router: Router, private route: ActivatedRoute, private service2: CarloanService) {
    this.route.params.subscribe(params => {
      this.ber = params['id1'];
    });
    this.route.params.subscribe(params => {
      this.specificationId = params['id4'];
    });
    this.route.params.subscribe(params => {
      this.gearSystem = params['data'];
    });
    this.route.params.subscribe(params => {
      this.carloanId = params['data1'];
      // console.log(this.carloanId);
    });

    if (this.gearSystem = "AT") {
      this.gear = "Auto";

    } else if (this.gearSystem = "MT") {
      this.gear = "Manual";
    }
  }

  ngOnInit() {
    this.sub = this.service.getSpecificationID(this.specificationId).subscribe((res) => {
      this.Specification = res;
    });
    this.sub = this.service2.getCarloanId(this.carloanId).subscribe((res) => {
      this.carloan = res;
    });
  }
  i: number;
  idcardnumber: any;
  nn: String;
  save() {
    // console.log(this.customer);
    this.httpClient.post("//localhost:8080/data/Customer/save/"+this.carloanId,
      this.customer)
      .subscribe(
        data => {
          // console.log('PUT Request is successful', data);
          this.router.navigate(['/home']);
        },
        error => {
          console.log('Rrror', error);
        }
      )
  }

}
