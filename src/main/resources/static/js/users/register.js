$(function() {
    $('button[type=submit]').click(function(e) {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer= '#successModal';
        var mdisplay = "#messagesuccess";
        e.preventDefault();
        //Remove all errors
       // $('input').next().remove();
        $.post({
            url: '/users/add',
            data: $('form[name=userForm]').serialize(),
            success : function(res) {
                try {
                    if (res.validated) {
                        //Set response
                        $(mdisplay).text("Utente registrato correttamente");
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            $(errorDisplay).text(value);
                            $(errorcontainer).modal('show');
                        });
                    }
                } catch (err)
                {
                    $(errorDisplay).value(err);
                    $(errorcontainer).modal('show');
                }
            },
            error: function () {
                $(errorDisplay).text("errore di connessione");
                $(errorcontainer).modal('show');
            }
        });

    });
})

