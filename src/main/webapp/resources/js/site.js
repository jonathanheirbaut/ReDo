/**
 * Created by JHRAU70 on 10/10/2014.
 */
function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.loggedIn) {
        PF('dlg').jq.effect("shake", {times: 5}, 100);
    }
    else {
        PF('dlg').hide();
        $('#loginLink').fadeOut();
    }
}
