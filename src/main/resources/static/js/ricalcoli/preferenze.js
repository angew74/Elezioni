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
        $('#Liste').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if (isValidSelect) {
            var aggregazione = $("#Aggregazione").val();
            var tipoRicalcolo = $("#TipoRicalcolo").val();
            var lista = $("#Liste").val();
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: '/dati/ricalcolapreferenze/' + aggregazione + '/' + tipoRicalcolo+ '/'+ lista,
                dataType: 'json'
            })
                .done(function (data) {
                    try {
                        if (data !== null) {
                            var responseRicalcolo = data;
                            $("#RicalcoloPreferenzeTable").DataTable({
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
                                    { data: "lista.denominazione" },
                                    { data: "candidato.nome" },
                                    { data: "candidato.cognome" },
                                    { data: "numerovoti" },
                                    { data: "votantipervenute"},
                                    { data: "iscrittipervenute" },
                                    { data: "percentualevotantipervenute" }
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
                    $(errorDisplay).text("errore di connessione dettagli: " + $.parseJSON(e.responseText).details[0]);
                    $(errorcontainer).modal('show');
                });
        }
    }
    function  ajaxSalvaRicalcolo() {
        var aggregazione = $("#Aggregazione").val();
        var tipoRicalcolo = $("#TipoRicalcolo").val();
        var lista = $("#Liste").val();
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/dati/salvaricalcolopreferenze/' + aggregazione + '/' + tipoRicalcolo+ "/"+ lista,
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
