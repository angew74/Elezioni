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
        if ($("#numeroPlesso").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Utente").parsley().validate() !== true) {
            isValid = false;
        }
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    }))
        $('#descrizionePlesso').autocomplete({
            source : function(request, response) {
                $.ajax({
                    url : '/interrogazioni/autocompletePlesso',
                    dataType : "json",
                    data : {
                        q : request.term,
                        t : "D"
                    },
                    success : function(data) {
                        response(data);
                    }
                });
            },
            minLength : 4,
            delay:500
        });

    $('#ubicazionePlesso').autocomplete({
        source : function(request, response) {
            $.ajax({
                url : '/interrogazioni/autocompletePlesso',
                dataType : "json",
                data : {
                    q : request.term,
                    t: "U"
                },
                success : function(data) {
                    response(data);
                }
            });
        },
        minLength : 4,
        delay:500
    });

    $('#Utente').autocomplete({
        source : function(request, response) {
            $.ajax({
                url : '/interrogazioni/autocompleteUser',
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
        delay:500
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
        $.post({
            url: '/search/plesso',
            data: $('form[name=rplessoForm]').serialize(),
            success: function (res) {
                try {
                    if (res.validated) {

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
