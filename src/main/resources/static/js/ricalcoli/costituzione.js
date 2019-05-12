jQuery(document).ready(function ($) {
    $('#butttonRicalcolo').click(function(){
        ajaxPostRicalcolo();
    });
    $("#btnSalvaRicalcoloCostituzione").on('click', ajaxSalvaRicalcolo);
    $("#btnSalvaRicalcoloApertura").on('click', ajaxSalvaRicalcolo);

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
                url: '/dati/ricalcolacostituzione/' + aggregazione + '/' + tipoRicalcolo,
                dataType: 'json'
            })
                .done(function (data) {
                    try {
                        if (data !== null) {
                            if(data.length > 5)
                            {
                                $("#footer").removeClass("absolute");
                                $("#footer").addClass("relative");
                            }
                            else {
                                $("#footer").removeClass("relative");
                                $("#footer").addClass("absolute");
                            }
                            var responseRicalcolo = data;
                            if(tipoRicalcolo === "CO1") {
                                $("#RicalcoloCostituzioneTable").DataTable({
                                    data: responseRicalcolo,
                                    searching: false,
                                    paging: false,
                                    info: false,
                                    destroy: true,
                                    columns: [
                                        {data: "municipio"},
                                        {data: "numerocostituite"},
                                        {data: "numerosezioni"},
                                        {data: "percentualecostituite"},
                                        {data: "iscrittitotali"}
                                    ]
                                });
                                $("#VisualizzazioneRicalcoloCostituzione").show();
                                $("#VisualizzazioneRicalcoloApertura").hide();
                            }
                            if(tipoRicalcolo === "AP1")
                            {
                                $("#RicalcoloAperturaTable").DataTable({
                                    data: responseRicalcolo,
                                    searching: false,
                                    paging: false,
                                    info: false,
                                    destroy: true,
                                    columns: [
                                        {data: "municipio"},
                                        {data: "numeroaperte"},
                                        {data: "numerosezioni"},
                                        {data: "percentualeaperte"},
                                        {data: "iscrittitotali"}
                                    ]
                                });
                                $("#VisualizzazioneRicalcoloApertura").show();
                                $("#VisualizzazioneRicalcoloCostituzione").hide();
                            }
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
                    $(errorDisplay).text("errore di connessione dettagli " + $.parseJSON(e.responseText).details[0]);
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
            url: '/dati/salvaricalcolocostituzione/' + aggregazione + '/' + tipoRicalcolo,
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
