export class Fournisseur {
    id?: number; // Correspond à Long en Java
    nom?: string;
    contact!: string; // Le point d'exclamation signifie que cette propriété est obligatoire
    qualiteService?: string;
    note?: number;
  }

