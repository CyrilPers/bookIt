
export function checkForm (input: string): String[] {
  const errors = [];
    if (input.length < 8)
      errors.push('Le mot de passe doit contenir au moins 8 caractères');
    if (!containsSpecialCharacter(input))
      errors.push('Le mot de passe doit contenir au moins un caractère spécial');
    if (!containsNumber(input))
      errors.push('Le mot de passe doit contenir au moins un chiffre');
    if (!containsUpperCase(input))
      errors.push('Le mot de passe doit contenir au moins une majuscule');
    return errors;
  }

function containsSpecialCharacter(input: string): boolean {
  const regex = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
  return regex.test(input);
}

function containsNumber (input: string): boolean {
  const regex = /\d/;
  return regex.test(input);
}

function containsUpperCase(input: string): boolean {
  const regex = /[A-Z]/;
  return regex.test(input);
}
