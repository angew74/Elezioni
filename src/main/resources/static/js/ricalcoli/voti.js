jQuery(document).ready(function ($) {
    $('#butttonRicalcolo').click(function(){
        ajaxPostRicalcolo();
    });
    $("#btnSalvaRicalcolo").on('click', ajaxSalvaRicalcolo);

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
                url: '/dati/ricalcolavoti/' + aggregazione + '/' + tipoRicalcolo,
                dataType: 'json'
            })
                .done(function (data) {
                    try {
                        if (data !== null) {
                            var responseRicalcolo = data;
                            $("#RicalcoloAffluenzaTable").DataTable({
                                data:responseRicalcolo,
                                searching: false,
                                paging: false,
                                info: false,
                                destroy:true,
                                columns: [
                                    { data: "municipio" },
                                    { data: "numerosezioni" },
                                    { data: "totalesezioni" },
                                    { data: "percentualepervenute" },
                                    { data: "affluenzamaschi" },
                                    { data: "iscrittimaschi" },
                                    { data: "percentualemaschi"},
                                    { data: "affluenzafemmine" },
                                    { data: "iscrittifemmine" },
                                    { data: "percentualefemmine" },
                                    { data: "affluenzatotale" },
                                    { data: "iscrittitotali" },
                                    { data: "percentualetotale" }
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
    function  ajaxSalvaRicalcolo() {
        var aggregazione = $("#Aggregazione").val();
        var tipoRicalcolo = $("#TipoRicalcolo").val();
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/dati/salvaricalcolovoti/' + aggregazione + '/' + tipoRicalcolo,
            dataType: 'json'
        })
            .done(function (data) {
                try {
                    if (data !== null) {
                        $(mdisplay).text("Ricalcolo salvato correttamente");
                        $(successcontainer).modal('show');
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

});
