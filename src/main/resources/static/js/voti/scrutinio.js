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
        debugger;
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
        var group = $('input[name="liste.voti"]');
        if (group.length > 1) {
            group.each(function () {
                sum += parseFloat($(this)[0].value);
            });
        }
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


    function postScrutinio() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var mdisplay = "#messagesuccess";
        debugger;
        var formData = $('form[name=insertScrutinio]').serialize();
        $.post({
             url: '/voti/lreg',
            //url : '/dati/lreg',
           // type: "POST",
            data:formData,
            // dataType: 'json',
          //  success: function (data)
          //  {
                
           // },
           // fail: function (data) {

           // }
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
