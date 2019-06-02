jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).on('click', (function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
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
                        return {value: item.descrizione, label: item.descrizione, id:item.numero};
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
                    response(data);
                }
            });
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


    /*
    $(function() {
        $("#descrizionePlesso").autocomplete({
            source : function(request, response) {
                $.ajax({
                    url : '',
                    dataType : "json",
                    data : {
                        q : request.term
                    },
                    success : function(data) {
                        response(data);
                    }
                });
            },
            minLength : 4,
            delay:500,
            focus: function (event, ui) {
                $("#descrizionePlesso").val(ui.item.label);
                return false;
            },
            select: function (event, ui) {
                $("#descrizionePlesso").val(ui.item.name);
                return false;
            }
        })
       .data("ui-autocomplete")._renderItem = function (ul, item) {
            return $("<li>")
                .data("ui-autocomplete-item", item)
                .append("<a> " + item.name + "<br>" + item.email + "</a>")
                .appendTo(ul);
        };
    });
*/
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
                        var plessi = res.plessi;
                        $("#UtenteView").text(res.user.username);
                        $("#userid").val(res.user.id);
                        $("#plessoid").val(plessi[0].id);
                        if (plessi.length > 5) {
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
                                {data: "sezioni.sezione"},
                                {data: "sezioni.cabina"},
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
