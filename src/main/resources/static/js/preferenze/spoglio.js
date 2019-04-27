jQuery(document).ready(function ($) {
    var buttonSpoglio = '#btnSalvaSpoglio';
    $(buttonSpoglio).click(function (event) {
        event.preventDefault();
        var isValid = true;
        debugger;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
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
        if ($("#NumeroVoti").parsley().validate() !== true) {
            isValid = false;
        }
        var votanti = parseInt($('#Votanti').text());
        var iscritti = parseInt($('#Iscritti').text());
        var votilista =  parseInt($('#NumeroVoti').text());
        var sum = 0;
        var group = $('input[name="candidati.numerovoti"]');
        var count = $('#count').text();
        var fields = $( ":input" ).serializeArray();
        jQuery.each( fields, function( i, field ) {
            if(field.name.indexOf('voti') !== -1)
            {
                sum += parseFloat(field.value);
            }
        });

        if (sum > votanti) {
            $("#errorcontrol").append("Somma preferenze maggiore votanti " + sum + " > " + $("#Votanti").val());
            isValid = false;
            $("#errorcontrol").show();
        } else {
            $("#errorcontrol").text("");
            $("#errorcontrol").hide();
        }
        if (sum > iscritti) {
            $("#errorcontrol").append("Voti preferenze maggiore iscritti " + sum + " > " + $("#Iscritti").val());
            isValid = false;
            $("#errorcontrol").show();
        } else {
            $("#errorcontrol").text("");
            $("#errorcontrol").hide();
        }
        if(sum > (votilista * 2))
        {
            $("#errorcontrol").append("le preferenze non possono superare di 2 volte i voti di lista " + sum + " > " + $("#NumeroVoti").text() + "  *2 ");
            isValid = false;
            $("#errorcontrol").show();
        }
        if (isValid && isValidSelect) {
            postSpoglio();
        }
    })


    function postSpoglio() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        debugger;
        var formData= $('form[name=insertSpoglio]').serialize();
        $.post({
            url: '/preferenze/registra',
            data: formData,
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                            if (res.tipo === "PE") {
                            $("#spogliodiv").hide();
                            $(mdisplay).text("Spoglio Preferenze inserito correttamente");
                        }
                        if (res.tipo === "RPE") {
                            $("#spogliodivdiv").hide();
                            $(mdisplay).text("Rettifica Spoglio Preferenze inserita correttamente");
                        }
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            if(value === null)
                            {
                                $(errorDisplay).text("errore applicativo grave");
                            }
                            else {
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
})
