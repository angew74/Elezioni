jQuery(document).ready(function ($) {
    var buttonScrutinio = '#btnSalvaScrutinio';
    $(buttonScrutinio).click(function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        if ($("#tipo").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#numerosezione").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Votanti").parsley().validate() !== true) {
            isValid = false;
        }
        if ($("#Iscritti").parsley().validate() !== true) {
            isValid = false;
        }
        var votanti = parseInt($('#Votanti').text());
        var iscritti = parseInt($('#Iscritti').text());
        var sum = 0;
        debugger;
        var group = $('input[name="liste.voti"]');
        var count = $('#count').text();
        var fields = $( ":input" ).serializeArray();
        jQuery.each( fields, function( i, field ) {
            if(field.name.indexOf('voti') !== -1)
            {
                sum += parseFloat(field.value);
            }
        });
        if (sum !== votanti) {
            $("#errorcontrol").append("Somma scrutinio diversa da votanti " + sum + " <> " + $("#Votanti").val());
            isValid = false;
            $("#errorcontrol").show();
        } else {
            $("#errorcontrol").text("");
            $("#errorcontrol").hide();
        }
        if (sum > iscritti) {
            $("#errorcontrol").append("Voti scrutinio maggiore iscritti " + sum + " > " + $("#Iscritti").val());
            isValid = false;
            $("#errorcontrol").show();
        } else {
            $("#errorcontrol").text("");
            $("#errorcontrol").hide();
        }

        if (isValid && isValidSelect) {
            postScrutinio();
        }
    })

    function jQFormSerializeArrToJson(formSerializeArr){
        var jsonObj = {};
        jQuery.map( formSerializeArr, function( n, i ) {
            jsonObj[n.name] = n.value;
        });

        return jsonObj;
    }

    function postScrutinio() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        debugger;
       // var formData = $("#insertScrutinio").serialize();
       var formData= $('form[name=insertScrutinio]').serialize();
        $.post({
             url: '/voti/lreg',
            data: formData,
           success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        if (res.tipo === "VL") {
                            $("#scrutiniodiv").hide();
                            $(mdisplay).text("Scrutinio inserito correttamente");
                        }
                        if (res.tipo === "RVL") {
                            $("#scrutiniodiv").hide();
                            $(mdisplay).text("Rettifica Scrutinio inserita correttamente");
                        }
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            if(value === null)
                            {
                                $(errorDisplay).text("errore applicativo grave");
                            }
                            else {
                                $(errorDisplay).text(value);
                            }
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
