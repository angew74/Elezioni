
jQuery(document).ready(function ($) {
    $("#footer").removeClass("absolute");
    $("#footer").addClass("relative");
});

function update(id) {
    /*  Submit form using Ajax */
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var successcontainer = '#successModal';
    var mdisplay = "#messagesuccess";
    var abil = "#enabled" + id;
    var valueabil;
    if ($(abil).prop('checked')) {
        valueabil = 1;
    } else {
        valueabil = 0;
    }
   //  e.preventDefault();
    //Remove all errors
   //  $('input').next().remove();
    $.post({
        url: '/amministrazione/update',
        data: {id: id, abilitazione: valueabil},
        success: function (res) {
            try {
                if (res.validated) {
                    $(mdisplay).text("Abilitazione modificata correttamente");
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

