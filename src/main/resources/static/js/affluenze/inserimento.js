
jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).on('click',(function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValid = false;
        });
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    }))

        function ajaxPost() {
            var errorcontainer = '#errorModal';
            var errorDisplay = '#errorDisplay';
            var successcontainer = '#successModal';
            var mdisplay = "#messagesuccess";
            var form = $('form[name=rsezioneForm]').serialize();
            //   var dati = JSON.stringify(form);
            //   var dati = $('form[name=rsezioneForm]').serialize();
            //Remove all errors
            $('input').next().remove();
            $.post({
                url: '/search/sezione',
                data: $('form[name=rsezioneForm]').serialize(),
                success: function (res) {
                    try {
                        if (res.validated) {
                            //Set response
                             $("#cabina").text("Cabina: "  +res.iscritti.cabina);
                           //  var text = "Cabina:  "+ res.iscritti.cabina + " Municipio: " + res.iscritti.municipio;
                            $("#sezione").text("Sezione " + res.iscritti.numerosezione);
                            $("#numerosezione").val( res.iscritti.numerosezione);
                            $("#municipio").text("Municipio " + res.iscritti.municipio);
                            $("#iscrittifemmine").text("Iscritti femmine: " +res.iscritti.iscrittifemmine);
                            $("#iscrittimaschi").text(" Iscritti maschi: " + res.iscritti.iscrittimaschi);
                            $("#iscrittitotali").text("Iscrtti totali: " + res.iscritti.iscrittitotali);
                            $("#tipoelezione").text(res.iscritti.tipoelezione.descrizione);
                            $("#tiposezione").text(" Tipo sezione: " + res.iscritti.tiposezione.descrizione);
                            $("#sezionediv").show();
                            if(res.tipo === "C")
                            {
                                $("#costituzione").show();
                            }
                            if(res.tipo === "A")
                            {
                                $("#apertura").show();
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
        var sezione = $("#numerosezione").val();
        $('input').next().remove();
        $.get({
            url: '/affluenze/registra/' + tipo  + '/' + sezione,
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        if(res.tipo === "C")
                        {
                            $("#costituzione").show();
                        }
                        if(res.tipo === "A")
                        {
                            $("#apertura").show();
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






