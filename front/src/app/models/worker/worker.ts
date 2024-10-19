import {Company} from "../company/company";

export class Worker {
    id: number;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    password: string;
    companies: Company[];

    constructor(
        firstName: string = '',
        lastName: string = '',
        phone: string  = '',
        email: string  = '',
        password: string = '',
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.companies = [new Company()];
    }
}