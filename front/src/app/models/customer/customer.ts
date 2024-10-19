export class Customer {
    id: number;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    password: string;
    advertising: boolean;
    token: string;

    constructor(
        firstName: string = '',
        lastName: string = '',
        phone: string  = '',
        email: string  = '',
        password: string = '',
        advertising: boolean  = false,
        token: string = ''
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.advertising = advertising;
        this.token = token;
    }
}