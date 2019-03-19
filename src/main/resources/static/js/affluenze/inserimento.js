
jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).click(function (event) {
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
    })

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
                            $("#cabina").text(res.iscritti.cabina);
                            $("#municipio").text(res.iscritti.municipio);
                            $("#numerosezione").text(res.iscritti.numerosezione);
                            $("#iscrittifemmine").text(res.iscritti.iscrittifemmine);
                            $("#iscrittimaschi").text(res.iscritti.iscrittimaschi);
                            $("#iscrittitotali").text(res.iscritti.iscrittitotali);
                            $("#tipoelezione").text(res.iscritti.tipoelezione.descrizione);
                            $("#tiposezione").text(res.iscritti.tiposezione.descrizione);
                            $("#iscritticard").show();
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








