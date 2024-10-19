
export class User {
    id: number;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    password: string;
    token: any;

    constructor(
        id: number = 0,
        firstName: string = '',
        lastName: string = '',
        phone: string  = '',
        email: string  = '',
        password: string = '',
        token: any
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.token = token;
    }
}