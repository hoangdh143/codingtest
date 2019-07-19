$("#submit-btn").click(function (e) {
    $("#section-div").addClass("grayscale");
    $("#overlay").addClass("not-clickable");

    var url = "http://localhost:8080/user";

    var user = {
        phone: $("#phone").val(),
        firstName: $("#first-name").val(),
        lastName: $("#last-name").val(),
        birthday: $("#birthday").val(),
        gender: $("input[name='gender']:checked").val(),
        email: $("#email").val()
    };

   $.ajaxSetup({
       headers: {
           'Content-Type': 'application/json',
           'Accept': 'application/json',
           'Access-Control-Allow-Headers': 'x-requested-with'
       }
   });

    $.ajax({
        url: url,
        type: 'post',
        data: JSON.stringify(user),
        dataType: 'json',
        success: function (data) {
            window.location.href = 'login.html';
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            var responseJson = XMLHttpRequest['responseJSON'];
            var errorCode = responseJson['errorCode'];
            var validationError = responseJson['validationError'];

            if (errorCode === "INVALID_INFO") {
                throwValidationErrorMessage("error-msg-phone", validationError["phone"]);
                throwValidationErrorMessage("error-msg-first-name", validationError["firstName"]);
                throwValidationErrorMessage("error-msg-last-name", validationError["lastName"]);
                throwValidationErrorMessage("error-msg-birthday", validationError["birthday"]);
                throwValidationErrorMessage("error-msg-gender", validationError["gender"]);
                throwValidationErrorMessage("error-msg-email", validationError["email"]);
            }

            throwGeneralErrorMessage(responseJson["message"]);
            $("#section-div").removeClass("grayscale");
            $("#overlay").removeClass("not-clickable");
        }
    });

    var throwValidationErrorMessage = function(id, msg) {
        if (msg != null && id != null) {
            $(`#${id}`).html(msg);
            $(`#${id}`).removeClass("fade");
        }
    };

    var throwGeneralErrorMessage = function(msg) {
        if (msg != null) {
            $("#error-msg-general").html(msg);
            $("#error-msg-general").removeClass("fade");
        }
    };
});
