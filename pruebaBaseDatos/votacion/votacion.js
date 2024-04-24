const XHR = new XMLHttpRequest();
const xhrPost = new XMLHttpRequest();
malasPalabras = "puta,mierda,joder,mojon,asco,cabron,subnormal,payaso,asqueroso";

addEventListener('DOMContentLoaded',function() {

    if(getCookie("usuario") == "") {
        let comentario = document.getElementsByTagName("textarea")[0];
        comentario.style.display = "none"
    }

    let idTapa = "";
    let contenedorTapa = document.querySelector("#informacionTapa");
    let parametrosURL = ObtenerParametrosURL(window.location.href);
    let h3Informacion = document.querySelector("#txtInformacion");
    if (Object.keys(parametrosURL).includes("idTapa")) {
        idTapa = parametrosURL.idTapa;
    }

    let URL2 = "http://localhost:9093/gestion/tapas/"+idTapa;
    XHR.addEventListener('load',function() {
        datosTapa = JSON.parse(XHR.responseText);
        console.log(datosTapa)
        contenedorTapa.innerHTML = generarFicha(datosTapa);
    });

    XHR.open('GET',URL2, false);
    XHR.send();

    botonEnviar = document.querySelector("#btnEnviar");
    botonEnviar.addEventListener('click',function() {

        let radios = document.getElementsByTagName('input');
        let valorEstrellas;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].type === 'radio' && radios[i].checked) {
                valorEstrellas = radios[i].value;       
            }
        }

        let comentario = document.getElementsByTagName("textarea")[0].value.trim();
        let estrellasEnviar = parseInt(valorEstrellas)
        let tapaEnviar = parseInt(idTapa);
        let votacion = ""
        console.log("enviar");
        let correo = {
            correoElectronico: getCookie("usuario")
        }

        let tapa = {
            codigo: tapaEnviar
        }

        if (!document.getElementsByTagName("textarea")[0]) {
            votacion = {  
                valoracion: estrellasEnviar, 
                comentario: null,
                usuario: correo,
                tapa: tapa
            }
        } else {
            votacion = {  
                valoracion: estrellasEnviar, 
                comentario: comentario,
                usuario: correo,
                tapa: tapa
            }
        }
        console.log(votacion)
        if (filtrarPalabrasProhibidas(comentario,malasPalabras.split(","))) {
            console.log("No se puede enviar");
            document.getElementsByTagName("textarea")[0].value = "";
            h3Informacion.textContent = "¡No puede poner un comentario ofensivo!"
        } else {
            console.log ("Se puede enviar")
            let post = JSON.stringify(votacion);
            let urlPost = "http://localhost:9093/gestion/valoraciones"
            xhrPost.open('POST', urlPost, true);
            xhrPost.setRequestHeader('Content-type', 'application/json');
            xhrPost.onload = function () {
            if(xhrPost.status === 200) {
                console.log("valoracion enviada")
                window.location.replace("finalVotacion/finalVotacion.html");
            }
        }
        xhrPost.send(post);
        }
    })
})

function generarFicha(datos) {
    let html = "";
    html += `<article><h1>${datos.nombre}</h1><img class='imgTapa' src='../imagenes/tapas/${datos.nombre}.jpeg'></article>`
    return html;
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

function filtrarPalabrasProhibidas(frase, palabrasProhibidas) {
    frase = frase.toLowerCase();
    let palabras = frase.split(" ");
      for (var i = 0; i < palabras.length; i++) {
      let palabra = palabras[i];
        palabra = palabra.replace(/^\W+|\W+$/g, "");
        if (palabrasProhibidas.includes(palabra)) {
            return true; 
        }
    }
    return false;
}

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