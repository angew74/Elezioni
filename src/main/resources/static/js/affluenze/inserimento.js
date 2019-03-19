
jQuery(document).ready(function ($) {
    var button = '#submitSearch';
    $(button).click(function (event) {
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValid = false;
        });
        if (isValid && isValidSelect) {
            ajaxPost();
        }

        function ajaxPost() {
            var errorcontainer = '#errorModal';
            var errorDisplay = '#errorDisplay';
            var successcontainer = '#successModal';
            var mdisplay = "#messagesuccess";
            e.preventDefault();
            //Remove all errors
            $('input').next().remove();
            $.ajax({
                url: '/search/sezione',
                type: "POST",
                contentType: "application/json",
                dataType: 'json',
                data: $('form[name=rsezioneForm]').serialize()
            }).done(function (data) {
                try {
                    if (data !== null && data.id !== null) {

                    }
                } catch (err) {

                }
            })
                .fail(function (e) {
                    $(errorDisplay).text("errore di connessione dettagli " + e);
                    $(errorcontainer).modal('show');
                });
        }
    })

});








