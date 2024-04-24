const XHR = new XMLHttpRequest();
const XHR3 = new XMLHttpRequest();

addEventListener('DOMContentLoaded',function() {
    let URL = "http://localhost:9093/gestion/usuarios";
    let mensaje = document.querySelector("#txtMensaje");
    XHR.addEventListener('load',function() {
        datos = JSON.parse(XHR.responseText);

        let acceder = document.querySelector("#btnAcceder");
        
        acceder.addEventListener('click',function() {
            let correoElectronico = document.querySelector("#txtCorreo").value;
            let passwordSinEncriptar = document.querySelector("#txtPassword").value;
            let password = CryptoJS.MD5(passwordSinEncriptar).toString();
            
            let buscar = datos.find(o => o.correoElectronico === correoElectronico && o.password === password);
            if (typeof buscar === "undefined") {
                mensaje.textContent = "Acceso denegado"
            } else {
                let parametrosURL = ObtenerParametrosURL(window.location.href);
                if (Object.keys(parametrosURL).includes("idTapa")) {
                    let puede = true;
                    let URL3 = "http://localhost:9093/gestion/valoraciones/";
                    XHR3.addEventListener('load',function() {
                        datosComentarios = JSON.parse(XHR3.responseText);
                        console.log(datosComentarios)
                        for (let i=0;i<datosComentarios.length;i++) {
                            if (datosComentarios[i].usuario.correoElectronico == correoElectronico && datosComentarios[i].tapa.codigo == parametrosURL.idTapa) {
                                mensaje.textContent = "¡Ya has puntuado esta tapa!";
                                puede = false
                            }
                        }
                    });

                    XHR3.open('GET',URL3, false);
                    XHR3.send();
                    if (puede) {
                        mensaje.textContent = "Acceso permitido"
                        setCookie("usuario",correoElectronico);
                        window.location.replace("../votacion/votacion.html?idTapa="+parametrosURL.idTapa);
                    }
                } else {
                    mensaje.textContent = "Se ha producido un error"
                }
            }
        });

        let registrar = document.querySelector("#btnRegistrar");
        registrar.addEventListener('click',function() {
            let correoElectronico = document.querySelector("#txtCorreo").value;
            let passwordSinEncriptar = document.querySelector("#txtPassword").value;
            let password = CryptoJS.MD5(passwordSinEncriptar).toString();
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
                        let parametrosURL = ObtenerParametrosURL(window.location.href);
                        if (Object.keys(parametrosURL).includes("idTapa")) {
                            mensaje.textContent = "Acceso permitido"
                            setCookie("usuario",correoElectronico);
                            window.location.replace("../votacion/votacion.html?idTapa="+parametrosURL.idTapa);
                        } else {
                            mensaje.textContent = "Se ha producido un error"
                        }
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
            let parametrosURL = ObtenerParametrosURL(window.location.href);
            if (Object.keys(parametrosURL).includes("idTapa")) {
                mensaje.textContent = "Acceso permitido"
                setCookie("usuario","");
                window.location.replace("../votacion/votacion.html?idTapa="+parametrosURL.idTapa);
            } else {
                mensaje.textContent = "Se ha producido un error"
            }
    });


})

function setCookie (clave,valor) {
    document.cookie = clave+"="+valor+";SameSite=Lax";
}

function ObtenerParametrosURL(qs) {
    qs = qs.split('?');
    qs.shift();

    var params = {},
        tokens,
        re = /[?&]?([^=]+)=([^&]*)/g;

    while (tokens = re.exec(qs)) {
        params[decodeURIComponent(tokens[1])] = decodeURIComponent(tokens[2]);
    }

    return params;
}

function delete_cookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}