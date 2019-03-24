jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).on('click', (function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if ($("#numeroSezione").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#numeroCabina").parsley().validate() !== true) {
            isValid = false;
        }
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    }))

    function ajaxPrepopulate() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        $.post({
            url: '/search/affluenza',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        if (res.tipo === "CO") {
                            $("#costituzione").show();
                        }
                        if (res.tipo === "AP") {
                            $("#apertura").show();
                        }
                        $("#tipoinput").val(res.tipo);
                        $("#numerosezioneinput").val(res.numerosezione)
                       var iscrittitotali = res.iscrittitotali +5;
                        var iscrittimaschi = res.iscrittimaschi +5;
                       var iscrittifemmine =  res.iscrittifemmine +5;
                        if (res.tipo === "1A") {
                            $("#1affluenza").show();
                            $("#votantiTotali").attr({
                                "max" : iscrittitotali ,        // substitute your own
                                "min" : 0         // values (or variables) here
                            });
                            $("#votantiMaschi").attr({
                                "max" : iscrittimaschi ,        // substitute your own
                                "min" : 0          // values (or variables) here
                            });
                            $("#votantiFemmine").attr({
                                "max" : iscrittifemmine,        // substitute your own
                                "min" : 0         // values (or variables) here
                            });
                        }
                        if (res.tipo === "2A" || res.tipo === "3A") {
                            $("#votantiMaschiaffp").val(res.votantimaschiaffp);
                            $("#votantiFemmineaffp").val(res.votantifemmineaffp);
                            $("#votantiTotaliaffp").val(res.votantitotaliaffp);
                            $("#votantiTotali").attr({
                                "max" :iscrittitotali ,        // substitute your own
                                "min" : res.votantitotaliaffp          // values (or variables) here
                            });
                            $("#votantiMaschi").attr({
                                "max" : iscrittimaschi,        // substitute your own
                                "min" : res.votantimaschiaffp          // values (or variables) here
                            });
                            $("#votantiFemmine").attr({
                                "max" :iscrittifemmine,        // substitute your own
                                "min" : res.votantifemmineaffp          // values (or variables) here
                            });
                            $("#divVotantiFemmineaffp").show();
                            $("#divVotantiMaschiaffp").show();
                            $("#divVotantiTotaliaffp").show();
                        }
                        if (res.tipo === "2A") {
                            $("#2affluenza").show();
                        }
                        if (res.tipo === "3A") {
                            $("#3affluenza").show();
                        }
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


    function ajaxPost() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        var form = $('form[name=rsezioneForm]').serialize();
        //   var dati = JSON.stringify(form);
        //   var dati = $('form[name=rsezioneForm]').serialize();
        //Remove all errors
        //  $('input').next().remove();
        $.post({
            url: '/search/sezione',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        $("#cabina").text("Cabina: " + res.iscritti.cabina);
                        //  var text = "Cabina:  "+ res.iscritti.cabina + " Municipio: " + res.iscritti.municipio;
                        $("#sezione").text("Sezione " + res.iscritti.numerosezione);
                        $("#numerosezioneinput").val(res.iscritti.numerosezione);
                        $("#numerosezione").val(res.iscritti.numerosezione);
                        $("#municipio").text("Municipio " + res.iscritti.municipio);
                        $("#iscrittifemmine").text("Iscritti femmine: " + res.iscritti.iscrittifemmine);
                        $("#iscrittimaschi").text(" Iscritti maschi: " + res.iscritti.iscrittimaschi);
                        $("#iscrittitotali").text("Iscrtti totali: " + res.iscritti.iscrittitotali);
                        $("#tipoelezione").text(res.iscritti.tipoelezione.descrizione);
                        $("#tiposezione").text(" Tipo sezione: " + res.iscritti.tiposezione.descrizione);
                        $("#sezionediv").show();
                        ajaxPrepopulate();
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
    var buttonApertura = '#buttonApertura';
    var buttonCostituzione = '#buttonCostituzione';
    $(buttonCostituzione).click(function (event) {
        event.preventDefault();
        postButtons();
    })
    $(buttonApertura).click(function (event) {
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
        //  $('input').next().remove();
        $.get({
            url: '/affluenze/registra/' + tipo + '/' + sezione,
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        if (res.tipo === "CO") {
                            $("#costituzione").hide();
                            $(mdisplay).text("Costituzione inserita correttamente");
                        }
                        if (res.tipo === "AP") {
                            $("#apertura").hide();
                            $(mdisplay).text("Apertura inserita correttamente");
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
        if (sum !== $("#votantiTotali"))
        {
            isValid = false;
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







