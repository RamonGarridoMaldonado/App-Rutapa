const XHR = new XMLHttpRequest();

addEventListener('DOMContentLoaded',function() {
    let URL = "http://localhost:9093/gestion/usuarios";
    XHR.addEventListener('load',function() {
        datos = JSON.parse(XHR.responseText);
        console.log(datos);

        let mensaje = document.querySelector("#txtMensaje");
        let acceder = document.querySelector("#btnAcceder");
        
        acceder.addEventListener('click',function() {
            console.log("acceder");
            let correoElectronico = document.querySelector("#txtCorreo").value;
            let passwordSinEncriptar = document.querySelector("#txtPassword").value;
            let password = CryptoJS.MD5(passwordSinEncriptar).toString();
            console.log(correoElectronico + " - "+ password);
            
            let buscar = datos.find(o => o.correoElectronico === correoElectronico && o.password === password);
            if (typeof buscar === "undefined") {
                mensaje.textContent = "Acceso denegado"
            } else {
                mensaje.textContent = "Acceso permitido"
                setCookie("usuario",correoElectronico);
                window.location.replace("establecimientos/inicio.html");
            }
        });

        let registrar = document.querySelector("#btnRegistrar");
        registrar.addEventListener('click',function() {
            console.log("registrar");
            let correoElectronico = document.querySelector("#txtCorreo").value;
            let passwordSinEncriptar = document.querySelector("#txtPassword").value;
            let password = CryptoJS.MD5(passwordSinEncriptar).toString();
            console.log(correoElectronico + " - "+ password);
            let existe = datos.find(o => o.correoElectronico === correoElectronico);
            if (typeof existe === "undefined") {
                let usuario = { 
                    codigo: 5, 
                    correoElectronico: correoElectronico, 
                    password: password
                }
                let post = JSON.stringify(usuario);
                const urlPost = "http://localhost:9093/gestion/usuarios"
                let xhrPost = new XMLHttpRequest();
                xhrPost.open('POST', urlPost, true);
                xhrPost.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
                xhrPost.send(post);
                xhrPost.onload = function () {
                    if(xhrPost.status === 200) {
                        mensaje.textContent = "Acceso permitido"
                        setCookie("usuario",correoElectronico);
                        window.location.replace("establecimientos/inicio.html");
                    }
                }
            } else {
                mensaje.textContent = "Este correo ya está registrado";
            }
        });

    })
    XHR.open('GET',URL, false);
    XHR.send();

    let botonInvitado = document.querySelector("#btnInvitado");
    botonInvitado.addEventListener('click',function() {
            setCookie("usuario","");
            window.location.replace("inicio.html");
    });


})

function setCookie (clave,valor) {
    document.cookie = clave+"="+valor+";SameSite=Lax";
}

