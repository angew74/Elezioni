// $(document).ready(function() {

function openListeModal(id) {
    var sezione = $("#numerosezione").val();
    var maxvotisindaco = $("#Votanti").text();
    $('#labelVotanti').text("Votanti " + maxvotisindaco);
    var v =  $('#labelVotanti').text();

    $.ajax({
        url: '/coalizioni/listecoalizione/' + id + '/' + sezione,
        success: function (data) {
            $("#listeModalHolder").html(data);
            $("#listeModal").modal('show');
            $("#sincolid").val(id);
            $("input[name='sincolid']").val(id);
            $("#maxvotisindaco").val(maxvotisindaco);
            $("input[name='maxvotisindaco']").val(maxvotisindaco);
        }
    })
}

$("#buttonSalva").click(function () {
    ajaxSalvaListeCoalizione();
})

function ajaxSalvaListeCoalizione() {
    event.preventDefault();
    var isValid = true;
    var isValidSelect = true;
    $('.votliliste').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    var sum = 0;
    var maxvotisindaco = $("#maxvotisindaco").val();
    var fields = $(".votliliste").serializeArray();
    jQuery.each(fields, function (i, field) {
        if (field.name.indexOf('voti') !== -1) {
            sum += parseFloat(field.value);
        }
    });

    if (sum > maxvotisindaco) {
        var message = "Somma voti lista superiore ai votanti " + sum + " > " + maxvotisindaco;
            boot4.alert(
                {
                    msg: message,
                    title: "Attenzione!",
                    callback: function() {
                        console.log("callback");
                    }
                },"OK");
        isValid = false;
    }
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var successcontainer = '#successModal';
    var mdisplay = "#messagesuccess";
    var formData = $('form[name=insertListe]').serialize();
    if (isValid && isValidSelect) {
        $.post({
            url: '/coalizioni/liste',
            data: formData,
            success: function (res) {
                try {
                    if (res.validated) {

                        $(mdisplay).text("Liste registrate correttamente");
                        var sindacoid = $("#sincolid").val();
                        var col = sindacoid -1;
                        var sindaco = '#sindaci' + col + '.iscoalizione';
                        var iconsindaco = "#iconcheck"+sindacoid;
                        $(iconsindaco).removeClass("far fa-circle");
                        $(iconsindaco).addClass("fas fa-check-circle");
                        $(sindaco).val("S");
                        $("#listeModal").modal('hide');
                        $(successcontainer).modal('show');
                        var sommaParziale = $("#contatoreListe").val();
                        var tot = sommaParziale + sum;
                        $("#contatoreListe").val(tot);

                    } else {
                        //Set error messages
                        $.each(res.errorMessages, function (key, value) {
                            if (value === null) {
                                $(errorDisplay).text("errore applicativo grave");
                            } else {
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
}

// });
