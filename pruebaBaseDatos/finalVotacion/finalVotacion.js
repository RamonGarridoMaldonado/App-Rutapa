addEventListener('DOMContentLoaded',function() {
    let btnVerPerfil = document.querySelector("#btnPerfil");
    btnVerPerfil.addEventListener('click',function() {
        if (getCookie("usuario") != "") {
            
        }       
    })
})

function getCookie (clave) {
    devolverCookie = ""
    x = document.cookie.split("; ");
    
    for (i=0;i<x.length;i++) {
        valor = x[i].split("=");
        if (clave == valor[0]) {
            devolverCookie = valor[1];
        }
    }

    return devolverCookie;
}


function setCookie (clave,valor) {
    document.cookie = clave+"="+valor+";SameSite=Lax";
}