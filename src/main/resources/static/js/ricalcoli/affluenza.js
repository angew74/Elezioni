jQuery(document).ready(function ($) {
    //  var presenzaForm = '#riepilogoButton';
    // $('#Mese').on('click', ajaxPostGiorni);
    // $('#Utente').on('click', ajaxPostMesi);
    $("#butttonRicalcolo").on('click', ajaxPostRicalcolo);

    function ajaxPostRicalcolo() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var id = $('#IdUserValue').val();
        var isValidSelect = true;
        $('#TipoRicalcolo').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('#Aggregazione').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if (isValidSelect) {
            var aggregazione = $("#Aggregazione").val();
            var tipoRicalcolo = $("#TipoRicalcolo").val();
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: '/dati/ricalcola/' + aggregazione + '/' + tipoRicalcolo,
                dataType: 'json'
            })
                .done(function (data) {
                    try {
                        if (data !== null) {
                            var responseRicalcolo = data;
                            $("#RicalcoloAffluenzaTable").DataTable({
                                data:responseRicalcolo,
                                columns: [
                                    { data: "municipio" },
                                    { data: "numerosezioni" },
                                    { data: "totalesezioni" },
                                    { data: "affluenzamaschi" },
                                    { data: "affluenzafemmine" },
                                    { data: "affluenzatotale" }
                                ]});
                       $("#VisualizzazioneRicalcolo").show();
                        } else {
                            //Set error messages
                            $.each(data.errorMessages, function (key, value) {
                                $(errorDisplay).text(value);
                            });
                            $(errorcontainer).modal('show');
                        }
                    } catch
                        (err) {
                        $(errorDisplay).text(err);
                        $(errorcontainer).modal('show');
                    }

                })
                .fail(function (e) {
                    $(errorDisplay).text("errore di connessione dettagli " + e);
                    $(errorcontainer).modal('show');
                });
        }
    }

});
