
function SaveAll() {
    var buttonScrutinio = '#btnSalvaScrutinio';
    // $(buttonScrutinio).click(function (event) {
    event.preventDefault();
    var isValid = true;
    var errorMessage;
    var isValidSelect = true;
    var isValidCount = false;
    var isValidCoalizione = false;
    $('select').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    $('input').each(function () {
        if ($(this).parsley().validate() !== true)
            isValid = false;
    });
    if ($("#tipo").parsley().validate() !== true) {
        isValid = false;
    }
    if ($("#numerosezione").parsley().validate() !== true) {
        isValid = false;
    }
    if ($("#Votanti").parsley().validate() !== true) {
        isValid = false;
    }
    if ($("#Iscritti").parsley().validate() !== true) {
        isValid = false;
    }
    if(isValid && isValidSelect) {
        isValidCoalizione = ValidateCoalizione();
    }
     if(isValid && isValidSelect && isValidCoalizione) {
         isValidCount = ValidateCount();
     }

    if (isValid && isValidSelect && isValidCount) {
        postScrutinio();
    }
    // })
}


function jQFormSerializeArrToJson(formSerializeArr) {
    var jsonObj = {};
    jQuery.map(formSerializeArr, function (n, i) {
        jsonObj[n.name] = n.value;
    });

    return jsonObj;
}

function ValidateCoalizione() {
    var isV = false;
    var errorcontainer = '#errorModal';
    var errorMessage = "";
    var errorDisplay = '#errorDisplay';
    var fields = $(":input").serializeArray();
    jQuery.each(fields, function (i, field) {
        if (field.name.indexOf('iscoalizione') !== -1) {
           if(field.value === "N" || field.value === "")
           {
               errorMessage = "Selezionare i voti di lista di tutte le coalizioni";
           }
        }
    });
    if (errorMessage !== "" && errorMessage !== null) {
        $("#errorcontrol").text("");
        $("#errorcontrol").append(errorMessage);
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');

    } else {
        $("#errorcontrol").text("");
        $("#errorcontrol").hide();
        $(errorDisplay).text('');
        $(errorcontainer).modal('hide');
        isV = true;
    }
    return isV;


}

function ValidateCount()
{
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var isV = false;
    var errorMessage ="";
    var votanti = parseInt($('#Votanti').text());
    var iscritti = parseInt($('#Iscritti').text());
    var validiListe = parseInt($('#valideliste').val());
    var solosindaco = parseInt($('#solosindaco').val());
    var totalevalide = parseInt($('#totalevalide').val());
    var bianche = parseInt($('#bianche').val());
    var nulle = parseInt($('#nulle').val());
    var contestate = parseInt($('#contestate').val());
    var totale = parseInt($('#totale').val());
    var sum = 0;
    var sumsolosindaco = 0;
    var group = $('input[name="liste.voti"]');
    var groupsolosindaco = $('input[name="liste.solosindaco"]');
 //    var fields = $(":input").serializeArray();
    $('.voti').each(function () {
            sum += parseFloat(this.value);
        });
    $('.votisolosindaco').each(function () {
        sumsolosindaco += parseFloat(this.value);
    });
    /*
    jQuery.each(fields, function (i, field) {
        if (field.name.indexOf('solosindaco') !== -1) {
            sumsolosindaco += parseFloat(field.value);
        }
    });*/
    var sommaListe = parseInt($("#contatoreListe").val());
    var sommaab = validiListe + solosindaco;
    var sommacdef = sommaab + bianche + nulle + contestate;
    if (solosindaco !== sumsolosindaco) {
        errorMessage = "Totale voti solo sindaco (B) diverso da somma voti singoli candidati " + solosindaco + " <> " + sumsolosindaco;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (validiListe !== sommaListe) {
        errorMessage = "Totale voti validi liste (A) diverso da somma voti singole liste " + validiListe + " <> " + sommaListe;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (totalevalide !== sommaab) {
        errorMessage = "Totale voti validi (C) diverso da somma  voti validi liste (a) + solo sindac (b) " + totalevalide + " <> " + sommaab;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (totale !== votanti) {
        errorMessage = "Totale (G) diverso da votanti " + totale + " <> " + votanti;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (sum !== totalevalide) {
        errorMessage = "Totale candidati diverso da voti validi (C) " + sum + " <> " + totalevalide;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (sommacdef !== votanti) {
        errorMessage = "Somma scrutinio singoli candidati diversa da votanti " + sum + " <> " + votanti;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (sommacdef > iscritti) {
        errorMessage = "Voti scrutinio maggiore iscritti " + sum + " > " + iscritti;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (sommacdef !== totale) {
        errorMessage = "Totale voti scrutinio (G) diverso da somma parziali (C+D+E+F) " + totale + " <> " + sommacdef;
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);
        return;
    }
    if (errorMessage !== "" && errorMessage != null) {
        $("#errorcontrol").text("");
        $(errorDisplay).text(errorMessage);
        $(errorcontainer).modal('show');
        $("#errorcontrol").append(errorMessage);

    } else {
        $(errorDisplay).text('');
        $(errorcontainer).modal('hide');
        $("#errorcontrol").text("");
        $("#errorcontrol").hide();
         isV = true;
    }
    return isV;
}

function postScrutinio() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var successcontainer = '#successModal';
    var mdisplay = "#messagesuccess";
    debugger;
    // var formData = $("#insertScrutinio").serialize();
    var formData = $('form[name=insertScrutinio]').serialize();
    $.post({
        url: '/coalizioni/coalreg',
        data: formData,
        success: function (res) {
            try {
                if (res.validated) {
                    //Set response
                    if (res.tipo === "VS") {
                        $("#scrutiniodiv").hide();
                        $(mdisplay).text("Scrutinio inserito correttamente");
                    }
                    if (res.tipo === "RVS") {
                        $("#scrutiniodiv").hide();
                        $(mdisplay).text("Rettifica Scrutinio inserita correttamente");
                    }
                    $(successcontainer).modal('show');
                } else {
                    //Set error messages
                    $.each(res.errorMessages, function (key, value) {
                        if (value === null) {
                            $(errorDisplay).text("errore applicativo grave");
                        } else {
                            $(errorDisplay).text(value);
                        }
                        $(errorcontainer).modal('show');
                    });
                }
            } catch (err) {
                $(errorDisplay).text(err);
                $(errorcontainer).modal('show');
            }
        },
        error: function () {
            $(errorDisplay).text("errore di connessione");
            $(errorcontainer).modal('show');
        }
    });
}

// })
