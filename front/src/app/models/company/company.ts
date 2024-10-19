export class Company {
    id: number;
    name: string;
    siret: string;
    phone: string;
    description: string;
    constructor(
        name: string = '',
        siret: string  = '',
        phone: string  = '',
        description: string  = '',
    ) {
        this.name = name;
        this.siret = siret;
        this.phone = phone;
        this.description = description;
    }
}