jQuery(document).ready(function ($) {
    $('#butttonInterroga').click(function () {
        ajaxPostInterrogazioni();
    });
    $('#Aggregazione').on('click', ajaxPostAggregazione);
});

function ajaxPostAggregazione() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var aggregazione = $("#Aggregazione").val();
    if (aggregazione === "SEZ") {
        $("#divsezione").show();
    }
    if (aggregazione === "PLE") {
        $("#divplesso").show();
    }
}


function ajaxPostInterrogazioni() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var id = $('#IdUserValue').val();
    var isValidSelect = true;
    var aggregazione = $("#Aggregazione").val();
    $('#TipoInterrogazione').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    $('#Aggregazione').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
   if($("#divsezione").is(":visible") === true)
    {
        if ($("#numeroSezione").parsley().validate() !== true)
            isValidSelect = false;
    }
    if($("#divplesso").is(":visible") === true)
    {
        if ($("#numeroPlesso").parsley().validate() !== true)
            isValidSelect = false;
    }
    if (isValidSelect) {
        var aggregazione = $("#Aggregazione").val();
        var tipoInterrogazione = $("#TipoInterrogazione").val();
        var sezione = $("#numeroSezione").val();
        var plesso = $("#numeroPlesso").val();
        if(sezione === "")
        {sezione = 0;}
        if(plesso === "")
        {
            plesso = 0;
        }
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/interrogazioni/affluenza/' + aggregazione + '/' + tipoInterrogazione + "/" + sezione + "/" + plesso,
            dataType: 'json'
        })
            .done(function (data) {
                try {
                    if (data !== null) {
                        var responseInterrogazione = data;
                        if (aggregazione === "SEZ" || aggregazione === "PLE") {
                            $("#InterrogazioneAffluenzaTableSez").DataTable({
                                data: responseInterrogazione,
                                searching: false,
                                paging: false,
                                info: false,
                                destroy: true,
                                columns: [
                                    {data: "municipio"},
                                    {data: "sezione"},
                                    {data: "affluenzamaschi"},
                                    {data: "iscrittimaschi"},
                                    {data: "percentualemaschi"},
                                    {data: "affluenzafemmine"},
                                    {data: "iscrittifemmine"},
                                    {data: "percentualefemmine"},
                                    {data: "affluenzatotale"},
                                    {data: "iscrittitotali"},
                                    {data: "percentualetotale"}
                                ]
                            });
                            $("#VisualizzazioneInterrogazioneSez").show();
                            $("#VisualizzazioneInterrogazione").hide();
                        } else {
                            $("#InterrogazioneAffluenzaTable").DataTable({
                                data: responseInterrogazione,
                                searching: false,
                                paging: false,
                                info: false,
                                destroy: true,
                                columns: [
                                    {data: "municipio"},
                                    {data: "numerosezioni"},
                                    {data: "totalesezioni"},
                                    {data: "percentualepervenute"},
                                    {data: "affluenzamaschi"},
                                    {data: "iscrittimaschi"},
                                    {data: "percentualemaschi"},
                                    {data: "affluenzafemmine"},
                                    {data: "iscrittifemmine"},
                                    {data: "percentualefemmine"},
                                    {data: "affluenzatotale"},
                                    {data: "iscrittitotali"},
                                    {data: "percentualetotale"}
                                ]
                            });
                            $("#VisualizzazioneInterrogazione").show();
                            $("#VisualizzazioneInterrogazioneSez").hide();
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
