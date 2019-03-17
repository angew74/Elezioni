
$(document).ready(function () {
        var usercontainer = '#userDetailsModal';
        $(usercontainer).modal('hide');
    }
);
function viewService(id) {
    /*  Submit form using Ajax */
    var usernamediv = '#username';
    var usercontainer = '#userDetailsModal';
    var maildiv = '#mail';
    var rolediv = '#roles';
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var enabledDisplay = '#displayendisabled';
    //Remove all errors
    // $(idbutton).next().remove();
    var iconenabled = "fa fa-toggle-on";
    var spandisabled = "#icondisabled";
    var icondisabled = "fa fa-toggle-off";

    $.post({
        url: '/users/view',
        data: {id: id},
        success: function (res) {
            try {
                $(rolediv).text('');
                if (res.validated) {
                    //Set response
                    $(usercontainer).modal('show');
                    $(usernamediv).text(res.user.username);
                    $(maildiv).text(res.user.mailaziendale);
                    if (res.user.enabled)
                    {
                        $(enabledDisplay).text('Abilitato');
                        $(spandisabled).removeClass(icondisabled);
                        $(spandisabled).addClass(iconenabled);

                    }
                    $.each(res.user.authorities, function (index, obj) {
                        $(rolediv).append(obj.authority + "<br />");
                    });

                } else {
                    //Set error messages
                    $.each(res.errorMessages, function (key, value) {
                        $(errorDisplay).text(value);
                        $(errorcontainer).modal('show');
                    });
                }
            } catch (err)
            {
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



function editService(id) {
    /*  Submit form using Ajax */
    var usernamediv = '#usernameedit';
    var usercontainer = '#userEditModal';
    var maildiv = '#mailedit';
    var rolediv = '#rolesedit';
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var iduseredit = '#iduseredit';
    var able = '#able';
    var disable = '#disable';
    var passworddiv = '#passwordedit';
    $.post({
        url: '/users/view',
        data: {id: id},
        success: function (res) {
            try {
                if (res.validated) {
                    //Set response
                    $(usercontainer).modal('show');
                    $(usernamediv).val(res.user.username);
                    $(iduseredit).val(res.user.id);
                    $(maildiv).val(res.user.mailaziendale);
                    $(passworddiv).val(res.user.password);
                    if (res.user.enabled)
                    {
                        $(able).prop('checked', true);
                        $(disable).prop('checked', false);
                        //  $(enabledDisplay).text('Abilitato');
                        // $(spandisabled).removeClass(icondisabled);
                        //  $(spandisabled).addClass(iconenabled);

                    }
                    var v = '';
                    $.each(res.user.authorities, function (index, obj) {
                        if (!(obj === null && obj === undefine))
                        {
                            if(index > '0')
                            {
                                v +=',';
                            }
                            v += obj.authority;
                        }
                    });
                    $(rolediv).val(v);
                } else {
                    //Set error messages
                    $.each(res.errorMessages, function (key, value) {
                        $(errorDisplay).text(value);
                        $(errorcontainer).modal('show');
                    });
                }
            } catch (err)
            {
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



jQuery(document).ready(function ($) {

    var useredit = '#submitEditUser';
    // SUBMIT FORM
    $(useredit).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost() {

        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var usercontainer = '#userEditModal';
        var usernamediv = '#usernameedit';
        var usercontainer = '#userEditModal';
        var maildiv = '#mailedit';
        var rolediv = '#rolesedit';
        var passworddiv = '#passwordedit';
        var iduseredit = '#iduseredit';
        var formData = {}
        formData["id"] = $(iduseredit).val();
        formData["password"] = $(passworddiv).val();
        formData["username"] = $(usernamediv).val();
        formData["mailaziendale"] = $(maildiv).val();
        formData["roles"] =  $(rolediv).val();
        var able = '#able';
        var mdisplay = "#messagesuccess";
        if($(able).is(':checked'))
        {
            formData["enabled"] = true;
        }else {
            formData["enabled"] = false;
        }
        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: '/users/modify',
            data: JSON.stringify(formData),
            dataType: 'json'})
            .done(function (data) {
                try {
                    if (data.validated) {
                        //Set response
                        $(usercontainer).modal('hide');
                        $(mdisplay).text("Utente modificato correttamente");
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(data.errorMessages, function (key, value) {
                            $(errorDisplay).text(value);
                        });
                        $(usercontainer).modal('hide');
                        $(errorcontainer).modal('show');
                    }
                } catch (err)
                {
                    $(errorDisplay).text(err);
                    $(errorcontainer).modal('show');
                    $(usercontainer).modal('hide');
                }

            })
            .fail(function (e) {
                $(errorDisplay).text("errore di connessione dettagli " + e);
                $(errorcontainer).modal('show');
                $(usercontainer).modal('hide');
            });

    }
})



