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
        var tipoPagina = $("#tipopagina").val();
        $.post({
            url: '/search/affluenza',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        if (res.tipo === "CO") {
                            $("#costituzione").show();
                        }
                        if (res.tipo === "RCO") {
                            $("#annullacostituzione").show();
                        }
                        if (res.tipo === "AP") {
                            $("#apertura").show();
                        }
                        if (res.tipo === "RAP") {
                            $("#annullaapertura").show();
                        }
                        $("#tipoinput").val(res.tipo);
                        $("#numerosezioneinput").val(res.numerosezione)
                        var iscrittitotali = res.iscrittitotali + 5;
                        var iscrittimaschi = res.iscrittimaschi + 5;
                        var iscrittifemmine = res.iscrittifemmine + 5;
                        if ((res.tipo === "1A" || res.tipo === "R1A") && tipoPagina != "A") {
                            $("#affluenza").show();
                            $("#votantiTotali").attr({
                                "max": iscrittitotali,        // substitute your own
                                "min": 0         // values (or variables) here
                            });
                            $("#votantiMaschi").attr({
                                "max": iscrittimaschi,        // substitute your own
                                "min": 0          // values (or variables) here
                            });
                            $("#votantiFemmine").attr({
                                "max": iscrittifemmine,        // substitute your own
                                "min": 0         // values (or variables) here
                            });
                            if (res.tipo === "R1A" && tipoPagina != "A") {
                                $("#votantiFemmine").val(res.votantifemmine);
                                $("#votantiMaschi").val(res.votantimaschi);
                                $("#votantiTotali").val(res.votantitotali);
                                $("#footer").removeClass("absolute");
                                $("#footer").addClass("relative");
                            }
                        }
                        if ((res.tipo === "2A" || res.tipo === "3C" || res.tipo === "R2A" || res.tipo === "R3C") && tipoPagina != "A") {
                            $("#votantiMaschiaffp").val(res.votantimaschiaffp);
                            $("#votantiFemmineaffp").val(res.votantifemmineaffp);
                            $("#votantiTotaliaffp").val(res.votantitotaliaffp);
                            $("#votantiTotali").attr({
                                "max": iscrittitotali,        // substitute your own
                                "min": res.votantitotaliaffp          // values (or variables) here
                            });
                            $("#votantiMaschi").attr({
                                "max": iscrittimaschi,        // substitute your own
                                "min": res.votantimaschiaffp          // values (or variables) here
                            });
                            $("#votantiFemmine").attr({
                                "max": iscrittifemmine,        // substitute your own
                                "min": res.votantifemmineaffp          // values (or variables) here
                            });
                            $("#divVotantiFemmineaffp").show();
                            $("#divVotantiMaschiaffp").show();
                            $("#divVotantiTotaliaffp").show();
                        }
                        if (res.tipo === "2A" || res.tipo === "R2A") {
                            if (tipoPagina != "A") {
                                $("#footer").removeClass("absolute");
                                $("#footer").addClass("relative");
                                $("#affluenza").show();
                            } else {
                                $("#annullaffluenza").show();
                            }
                        }
                        if (res.tipo === "3C" || res.tipo === "R3C") {
                            if (tipoPagina != "A") {
                                $("#footer").removeClass("absolute");
                                $("#footer").addClass("relative");
                                $("#affluenza").show();
                            } else {
                                $("#annullaffluenza").show();
                            }
                        }
                        if ((res.tipo === "1A" || res.tipo === "R1A") && tipoPagina === "A") {
                            $("#annullaffluenza").show();
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

    function ajaxPrepopulateVoti() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var tipoPagina = $("#tipopagina").val();
        $.post({
            url: '/search/voti',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        $("#numerosezioneinput").val(res.numerosezione)
                        var iscrittitotali = res.iscritti + 5;
                        var votanti = res.votanti;
                        $("#Votanti").text(votanti);
                        $("#Iscritti").text(res.iscritti);
                        var url = "/voti/scrutinio/" + res.tipo+ "/" + res.numerosezione;
                        $("#scrutiniodiv").load(url);
                        $("#scrutinio").show();
                        $("#scrutiniodiv").show();
                    }
                } catch (e) {
                    $(errorDisplay).text(e);
                    $(errorcontainer).modal('show');
                }

            },
            error: function () {
                $(errorDisplay).text("errore di connessione");
                $(errorcontainer).modal('show');
            }
        })
    }

    function ajaxPrepopulatePreferenze() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var tipoPagina = $("#tipopagina").val();
        var lista = $( "#Liste option:selected" ).val();
        $.post({
            url: '/search/preferenze',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        $("#numerosezioneinput").val(res.numerosezione)
                        var iscrittitotali = res.iscritti + 5;
                        var votanti = res.votanti;
                        $("#Votanti").text(votanti);
                        $("#Iscritti").text(res.iscritti);
                        $("#footer").removeClass("absolute");
                        $("#footer").addClass("relative");
                        var url = "/preferenze/spoglio/" + lista + "/" + res.tipo+ "/" + res.numerosezione;
                        $("#spogliodiv").load(url);
                        $("#spoglio").show();
                        $("#spogliodiv").show();
                    }
                } catch (e) {
                    $(errorDisplay).text(e);
                    $(errorcontainer).modal('show');
                }

            },
            error: function () {
                $(errorDisplay).text("errore di connessione");
                $(errorcontainer).modal('show');
            }
        })
    }


    function ajaxPost() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.post({
            url: '/search/sezione',
            data: $('form[name=rsezioneForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        $("#cabina").text("Cabina: " + res.iscritti.cabina);
                        //  var text = "Cabina:  "+ res.iscritti.cabina + " Municipio: " + res.iscritti.municipio;
                        $("#sezione").text("Sezione " + res.iscritti.sezione.numerosezione);
                        $("#numerosezioneinput").val(res.iscritti.sezione.numerosezione);
                        $("#numerosezione").val(res.iscritti.sezione.numerosezione);
                        $("#municipio").text("Municipio " + res.iscritti.municipio);
                        $("#iscrittifemmine").text("Iscritti femmine: " + res.iscritti.iscrittifemmine);
                        $("#iscrittimaschi").text(" Iscritti maschi: " + res.iscritti.iscrittimaschi);
                        $("#iscrittitotali").text("Iscrtti totali: " + res.iscritti.iscrittitotali);
                        $("#tipoelezione").text(res.iscritti.tipoelezione.descrizione);
                        $("#tiposezione").text(" Tipo sezione: " + res.iscritti.sezione.tiposezione.descrizione);
                        $("#sezionediv").show();
                        if (res.tipo === "RVL" || res.tipo === "VL") {
                            $("#footer").removeClass("absolute");
                            $("#footer").addClass("relative");
                            ajaxPrepopulateVoti();
                        }
                        if (res.tipo === "PE" || res.tipo === "RPE") {
                            $("#footer").removeClass("absolute");
                            $("#footer").addClass("relative");
                            ajaxPrepopulatePreferenze();
                        }
                        else {
                            ajaxPrepopulate();
                        }
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
