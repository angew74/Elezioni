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
        $("#divplesso").hide();
    }
    if (aggregazione === "PLE") {
        $("#divplesso").show();
        $("#divsezione").hide();
    }
}


function ajaxPostInterrogazioni() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var id = $('#IdUserValue').val();
    var isValidSelect = true;
    var aggregazione = $("#Aggregazione").val();
    var lista = $("#TipoLista").val();
    $('#TipoInterrogazione').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    $('#Aggregazione').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    $('#TipoLista').each(function () {
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
        var idlista = $("#TipoLista").val();
        if(sezione === "")
        {sezione = 0;}
        if(plesso === "")
        {
            plesso = 0;
        }
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/interrogazioni/preferenze/' + aggregazione + '/' + tipoInterrogazione + "/" + sezione + "/" + plesso +"/" + idlista,
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
                        var responseInterrogazione = data;
                        if (aggregazione === "SEZ" || aggregazione === "PLE") {
                            $("#InterrogazionePreferenzeTableSez").DataTable({
                                data: responseInterrogazione,
                                searching: false,
                                paging: false,
                                info: false,
                                destroy: true,
                                columns: [
                                    {data: "sezione"},
                                    {data: "municipio"},
                                    {data: "denominazioneLista"},
                                    {data: "denominazioneCandidato"},
                                    {data: "numerovoti"},
                                    {data: "percentualevoti"}
                                ]
                            });
                            $("#VisualizzazioneInterrogazioneSez").show();
                            $("#VisualizzazioneInterrogazione").hide();
                        } else {
                            $("#InterrogazionePreferenzeTable").DataTable({
                                data: responseInterrogazione,
                                searching: false,
                                paging: false,
                                info: false,
                                destroy: true,
                                columns: [
                                    { data: "municipio" },
                                    { data: "numerosezioni" },
                                    { data: "totalesezioni" },
                                    { data: "percentualepervenute" },
                                    { data: "denominazioneLista" },
                                    { data:"denominazioneCandidato"},
                                    { data: "numerovoti" },
                                    { data: "percentualevoti" }
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
