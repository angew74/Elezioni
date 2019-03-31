jQuery(document).ready(function ($) {
    var buttonScrutinio = '#btnSalvaScrutinio';
    $(buttonScrutinio).click(function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        debugger;
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if ($("#tipoblank").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#numerosezioneblank").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Votanti").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Iscritti").parsley().validate() !== true) {
            isValid = false;
        }
        var votanti = parseInt($('#Votanti').val());
        var iscritti = parseInt($('#Iscritti').val());
        var sum = 0;
        $('.voti').each(function()
        {
            sum += parseFloat($(this).text());
        });
        if (sum !== votanti)
        {
            $("#errorVotanti").text("Somma scrutinio diversa da votanti " + sum + " <> " + $("#Votanti").val());
            isValid = false;
        }
        else {
            $("#errorVotanti").text("");
        }
        if(sum > iscritti)
        {
            $("#errorIscritti").text("Voti scrutinio maggiore iscritti " + sum + " > " + $("#Iscritti").val());
            isValid = false;
        }
        else {
            $("#errorIscritti").text("");
        }

        if (isValid && isValidSelect) {
            postScrutinio();
        }
    })


    function postScrutinio() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.post({
            url: '/voti/lreg',
            data: $('form[name=insertScrutinio]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        if (res.tipo === "1A") {
                            $("#costituzione").hide();
                            $(mdisplay).text("1 Affluenza inserita correttamente");
                        }
                        if (res.tipo === "2A") {
                            $("#apertura").hide();
                            $(mdisplay).text("2 Affluenza inserita correttamente");
                        }
                        if (res.tipo === "3A") {
                            $("#apertura").hide();
                            $(mdisplay).text("Chiusura inserita correttamente");
                        }
                        if (res.tipo === "R1A") {
                            $("#costituzione").hide();
                            $(mdisplay).text("1 Affluenza rettificata");
                        }
                        if (res.tipo === "R2A") {
                            $("#apertura").hide();
                            $(mdisplay).text("2 Affluenza rettificata");
                        }
                        if (res.tipo === "R3A") {
                            $("#apertura").hide();
                            $(mdisplay).text("Chiusura rettificata");
                        }
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            $(errorDisplay).text(value);
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
