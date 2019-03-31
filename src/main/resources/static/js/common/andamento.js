jQuery(document).ready(function ($) {
    var buttonApertura = '#buttonApertura';
    var buttonCostituzione = '#buttonCostituzione';
    var buttonAnnullaApertura = '#buttonAnnullaApertura';
    var buttonAnnullaCostituzione = '#buttonAnnullaCostituzione';
    $(buttonCostituzione).click(function (event) {
        event.preventDefault();
        postButtons();
    })
    $(buttonAnnullaCostituzione).click(function (event) {
        event.preventDefault();
        postButtons();
    })
    $(buttonApertura).click(function (event) {
        event.preventDefault();
        postButtons();
    })
    $(buttonAnnullaApertura).click(function (event) {
        event.preventDefault();
        postButtons();
    })

    function postButtons() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        var tipo = $("#tipo").val();
        $("#tipoinput").val(tipo);
        var sezione = $("#numerosezione").val();
        var urlt= '/affluenze/apra/' + tipo + '/' + sezione
        if(tipo === "RCO" || tipo === "RAP")
        {
            urlt = '/affluenze/rapra/' + tipo + '/' + sezione;
        }
        //  $('input').next().remove();
        $.get({
            url: urlt,
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        if (res.tipo === "CO") {
                            $("#costituzione").hide();
                            $(mdisplay).text("Costituzione inserita correttamente");
                        }
                        if (res.tipo === "RCO") {
                            $("#annullacostituzione").hide();
                            $(mdisplay).text("Costituzione annullata correttamente");
                        }
                        if (res.tipo === "AP") {
                            $("#apertura").hide();
                            $(mdisplay).text("Apertura inserita correttamente");
                        }
                        if (res.tipo === "RAP") {
                            $("#annullaapertura").hide();
                            $(mdisplay).text("Apertura annullata correttamente");
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


jQuery(document).ready(function ($) {
    var buttonAffluenza = '#btnAnnullaAffluenza';
    $(buttonAffluenza).click(function (event) {
        event.preventDefault();
        postDeleteAffluenza();
    })


    function postDeleteAffluenza() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        var tipo = $("#tipo").val();
        var sezione = $("#numerosezione").val();
        $.get({
            url: '/affluenze/randa/'  + tipo + '/' + sezione,
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
                        if (res.tipo === "3C") {
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
                        if (res.tipo === "R3C") {
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

jQuery(document).ready(function ($) {
    var buttonAffluenza = '#btnSalvaAffluenza';
    $(buttonAffluenza).click(function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if ($("#tipoinput").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#numerosezioneinput").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#votantiMaschi").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#votantiFemmine").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#votantiTotali").parsley().validate() !== true) {
            isValid = false;
        }
        var sum = parseInt($('#votantiMaschi').val()) + parseInt($('#votantiFemmine').val());
        if (sum !== parseInt($("#votantiTotali").val()))
        {
            $("#errorVotantiTotali").text("Somma votanti errata " + sum + " <> " + $("#votantiTotali").val());
            isValid = false;
        }
        else {
            $("#errorVotantiTotali").text("");
        }
        if (isValid && isValidSelect) {
            postAffluenza();
        }
    })


    function postAffluenza() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.post({
            url: '/affluenze/anda',
            data: $('form[name=insertAffluenza]').serialize(),
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




