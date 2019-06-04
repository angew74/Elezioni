jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).on('click', (function (event) {
        event.preventDefault();
        var tipo = $("#tipoOperazione").val();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if ($("#Utente").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Utente").parsley().validate() !== true) {
            isValid = false;
        }

        if ($("#numeroPlesso").parsley().validate() !== true) {
            isValid = false;
        }
        var ubi = $("#ubicazionePlesso").val();
        var descr = $("#descrizionePlesso").val();
        var pl = $("#numeroPlesso").val();
        if (ubi === "" && descr === "" && pl === "") {
            isValid = false;
            errorUbicazionePlesso.text("inserire almeno una chiave di interrogazione relativa al plesso");
            errorDescrizionePlesso.text("inserire almeno una chiave di interrogazione relativa al plesso");
            errorPlesso.text("inserire almeno una chiave di interrogazione relativa al plesso");
            isValid = false;
        }
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    }))

    $("#btnSalvaAssociazione").on('click', ajaxSalvaAssociazione);

    $('#descrizionePlesso').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/interrogazioni/autocompletePlesso',
                dataType: "json",
                data: {
                    q: request.term,
                    t: "D"
                },
                success: function (data) {
                    // response(data);
                    response($.map(data, function (item) {
                        return {value: item.descrizione, label: item.descrizione, id: item.numero};
                    }));
                }
            });
        },
        search: function () {
            $("#numeroPlesso").val("");
        },
        focus: function (event, ui) {
            event.preventDefault();
        },
        select: function (event, ui) {
            $("#numeroPlesso").val(ui.item.id);
            $("#descrizionePlesso").val(ui.item.label);
        },
        minLength: 4,
        delay: 500
    });


    $('#ubicazionePlesso').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/interrogazioni/autocompletePlesso',
                dataType: "json",
                data: {
                    q: request.term,
                    t: "U"
                },
                success: function (data) {
                    // response(data);
                    response($.map(data, function (item) {
                        return {value: item.descrizione, label: item.descrizione, id: item.numero};
                    }));
                }
            });
        },
        search: function () {
            $("#numeroPlesso").val("");
        },
        focus: function (event, ui) {
            event.preventDefault();
        },
        select: function (event, ui) {
            $("#numeroPlesso").val(ui.item.id);
            $("#ubicazionePlesso").val(ui.item.label);
        },
        minLength: 4,
        delay: 500
    });


    $('#Utente').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/interrogazioni/autocompleteUser',
                dataType: "json",
                data: {
                    q: request.term
                },
                success: function (data) {
                    response(data);
                }
            });
        },
        minLength: 4,
        delay: 500
    });

    function ajaxSalvaAssociazione() {
        var user = $("#userid").val();
        var plesso = $("#plessoid").val();
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        $.get({
            contentType: "application/json",
            url: '/abilitazioni/associa?userid='+user+"&plessoid="+plesso,
            success: (function (data) {
                try {
                    if (data.validated) {
                        if (data !== null) {
                            $(mdisplay).text("Associazione salvata correttamente");
                            $(successcontainer).modal('show');
                        }
                    } else {
                        //Set error messages
                        $.each(data.errorMessages, function (key, value) {
                            if (value === null) {
                                $(errorDisplay).text("errore applicativo grave");
                            } else {
                                $(errorDisplay).text(value);
                            }
                            $(errorcontainer).modal('show');
                        });
                    }
                } catch
                    (err) {
                    $(errorDisplay).text(err);
                    $(errorcontainer).modal('show');
                }

            }),
            error: function () {
                $(errorDisplay).text("errore di connessione ");
                $(errorcontainer).modal('show');
            }
        });
    }

    function ajaxPost() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        var richiesta = $('form[name=rplessoForm]').serialize();
        $.post({
            url: '/search/plesso',
            data: richiesta,
            success: function (res) {
                try {
                    if (res.validated) {
                        var plessi = res.Plessi;
                        $("#UtenteView").text(res.user.username);
                        $("#userid").val(res.user.id);
                        $("#plessoid").val(plessi[0].numero);
                        if (plessi.length > 3) {
                            $("#footer").removeClass("absolute");
                            $("#footer").addClass("relative");
                        } else {
                            $("#footer").removeClass("relative");
                            $("#footer").addClass("absolute");
                        }
                        $("#PlessoTable").DataTable({
                            data: plessi,
                            searching: false,
                            paging: false,
                            info: false,
                            destroy: true,
                            columns: [
                                {data: "numero"},
                                {data: "descrizione"},
                                {data: "ubicazione"},
                                {data: "sezione"},
                                {data: "cabina"},
                                {data: "municipio"}
                            ]
                        });
                        $("#AssociazionePlessi").show();
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
