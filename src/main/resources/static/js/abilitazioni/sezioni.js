jQuery(document).ready(function ($) {
    var button = '#submitSearchInt';
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
            ajaxPostIntSez();
        }

        function ajaxPostIntSez() {
            var errorcontainer = '#errorModal';
            var errorDisplay = '#errorDisplay';
            var successcontainer = '#successModal';
            var mdisplay = "#messagesuccess";
            $.post({
                url: '/abilitazioni/intsez',
                data: $('form[name=rsezioneForm]').serialize(),
                success: function (res) {
                    try {
                        if (res.validated) {
                            //Set response
                            $("#cabina").text("Cabina: " + res.affluenzaJson.cabina);
                            //  var text = "Cabina:  "+ res.iscritti.cabina + " Municipio: " + res.iscritti.municipio;
                            $("#sezione").text("Sezione " + res.affluenzaJson.numerosezione);
                            $("#numerosezioneinput").val(res.affluenzaJson.numerosezione);
                            $("#numerosezione").val(res.affluenzaJson.numerosezione);
                            $("#municipio").text("Municipio " + res.affluenzaJson.municipio);
                            $("#iscrittifemmine").text("Iscritti femmine: " + res.affluenzaJson.iscrittifemmine);
                            $("#iscrittimaschi").text(" Iscritti maschi: " + res.affluenzaJson.iscrittimaschi);
                            $("#iscrittitotali").text("Iscrtti totali: " + res.affluenzaJson.iscrittitotali);
                            $("#votantimaschi").text("Votanti maschi: " + res.affluenzaJson.votantimaschi);
                            $("#votantifemmine").text(" Votanti femmine: " + res.affluenzaJson.votantifemmine);
                            $("#votantitotali").text("Votanti totali: " + res.affluenzaJson.votantitotali);
                            $("#tipoelezione").text(res.affluenzaJson.descrizione);
                            $("#sezionediv").show();
                            $("#footer").removeClass("absolute");
                            $("#footer").addClass("relative");
                            $("#sezionediv").show();
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


    }))
})