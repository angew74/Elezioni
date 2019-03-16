// Validation errors messages for Parsley


Parsley.addMessages('it', {
  defaultMessage: "Questo valore sembra essere non valido.",
  type: {
    email:        "Questo valore deve essere un indirizzo email valido.",
    url:          "Questo valore deve essere un URL valido.",
    number:       "Questo valore deve essere un numero valido.",
    integer:      "Questo valore deve essere un numero valido.",
    digits:       "Questo valore deve essere di tipo numerico.",
    alphanum:     "Questo valore deve essere di tipo alfanumerico."
  },
  notblank:       "Questo valore non deve essere vuoto.",
  required:       "Valore richiesto.",
  pattern:        "Valore non corretto.",
  min:            "Questo valore deve essere maggiore di %s.",
  max:            "Questo valore deve essere minore di %s.",
  range:          "Questo valore deve essere compreso tra %s e %s.",
  minlength:      "Valore troppo corto. Lunghezza minima di %s caratteri.",
  maxlength:      "Valore troppo lungo. Lunghezza massima di %s caratteri.",
  length:         "La lunghezza di questo valore deve essere compresa fra %s e %s caratteri.",
  mincheck:       "Devi scegliere almeno %s opzioni.",
  maxcheck:       "Devi scegliere al più %s opzioni.",
  check:          "Devi scegliere tra %s e %s opzioni.",
  equalto:        "Questo valore deve essere identico."
});

Parsley.setLocale('it');
