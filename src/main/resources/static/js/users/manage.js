
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
                    $.each(res.user.roles, function (index, obj) {
                        $(rolediv).append(obj + "<br />");
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
    var nomeedit = '#nomeedit';
    var cognomeedit = '#cognomeedit';
    var sessoedit = '#sessoedit';
    var codicefiscaleedit = '#codicefiscale';
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
                    $(nomeedit).val(res.user.nome);
                    $(cognomeedit).val(res.user.cognome);
                    $(sessoedit).val(res.user.sesso);
                    $(codicefiscaleedit).val(res.user.codicefiscale);
                    $(maildiv).val(res.user.mailaziendale);
                    $(passworddiv).val(res.user.password);
                    if (res.user.enabled)
                    {
                        $(able).prop('checked', true);
                        $(disable).prop('checked', false);

                    }
                    var v = '';
                    /*
                    $.each(res.user.authorities, function (index, obj) {
                        if (!(obj === null && obj === undefine))
                        {
                            if(index > '0')
                            {
                                v +=',';
                            }
                            v += obj.authority;
                        }
                    });*/

                    $.each(res.user.roles, function (index, obj) {
                        if (!(obj === null && obj === undefine))
                        {
                            if(index > '0')
                            {
                                v +=',';
                            }
                            v += obj;
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
    $(useredit).click(function (event) {
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
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    });


    function ajaxPost() {

        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        var usercontainer = '#userEditModal';
        var usernamediv = '#usernameedit';
        var usercontainer = '#userEditModal';
        var mdisplay = "#messagesuccess";
        var formData = $('form[name=userForm]').serialize()
        var able = '#able';
        if ($(able).is(':checked')) {
            formData["enabled"] = true;
        } else {
            formData["enabled"] = false;
        }
        // DO POST
        $.post({
            url: '/users/modify',
            data: formData,
            success: function (res) {
                try {
                    if (res.validated) {
                        //Set response
                        $(mdisplay).text("Utente modificato correttamente");
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            $(errorDisplay).text(value);
                            $(errorcontainer).modal('show');
                        });
                    }
                    $(usercontainer).modal('hide');
                } catch (err) {
                    $(errorDisplay).value(err);
                    $(errorcontainer).modal('show');
                }
            },
            error: function () {
                $(errorDisplay).text("errore di connessione");
                $(errorcontainer).modal('show');
            }
        })
    }

})



