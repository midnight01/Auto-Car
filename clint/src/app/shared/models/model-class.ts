export class car {
    specificationId?:any;
    typeCar?: any;
    brand?: any;
    generation?: any;
    carMakeover?: any;
    modelDetails?: any;
    year?: any;
    engineSize?: any;
    gearSystem?: any;
    numberSeats?: any;
    mileage?: any;
    color?: any;
    price?: any;
    image?: any;
}

export class Carloan {
    carloanId?:any;
    numberInstallment?: any;
    interest?: any;
    deposit?: any;
}

export class customer {
    customerId?:any;
    firstName?: any;
    lastName?: any;
    phoneNumber?: any;
    email?: any;
    idCardNumber?: any;
    jobStatus?: any;
    workExperience?: any;
    salaryBase?: any;
    carloac?: Carloan;

}
export class User {
    username: string;
    password: string;
    mobileNumber: string;
    email: string;
} 