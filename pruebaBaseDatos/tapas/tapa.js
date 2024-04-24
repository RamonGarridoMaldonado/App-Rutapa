const XHR2 = new XMLHttpRequest();
const XHR3 = new XMLHttpRequest();
datosTapa = "";
notaMedia = 0;

addEventListener('DOMContentLoaded',function() {
    let idTapa = "";
    let contenedorTapa = document.querySelector("#contenidoTapa");
    let parametrosURL = ObtenerParametrosURL(window.location.href)
    if (Object.keys(parametrosURL).includes("idTapa")) {
        idTapa = parametrosURL.idTapa;
    }

    let URL2 = "http://localhost:9093/gestion/tapas/"+idTapa;
    XHR2.addEventListener('load',function() {
        datosTapa = JSON.parse(XHR2.responseText);
        console.log(datosTapa)
        contenedorTapa.innerHTML = generarFicha(datosTapa);
    });

    XHR2.open('GET',URL2, false);
    XHR2.send();

    botonVolver = document.querySelector("#btnVolver");
    botonVolver.addEventListener('click',function() {
        window.location.replace("../establecimientos/inicio.html");
    });

    divAlergenos = document.querySelector("#contenedorAlergenos");
    for (let i=0;i<datosTapa.alergenos.length;i++) {
        let imagen = document.createElement("img");
        imagen.src = "../imagenes/alergenos/"+datosTapa.alergenos[i].nombre+".png";
        divAlergenos.appendChild(imagen)
    }

    divComentarios = document.querySelector("#contenedorComentarios");

    let URL3 = "http://localhost:9093/gestion/valoraciones/";
    XHR3.addEventListener('load',function() {
        datosTapa = JSON.parse(XHR3.responseText);
        for (let i=0;i<datosTapa.length;i++) {
            if (datosTapa[i].tapa != null) {
                if (datosTapa[i].tapa.codigo==idTapa) {
                    notaMedia+=parseInt(datosTapa[i].valoracion)
                    divComentarios.appendChild(generarComentario(datosTapa[i].valoracion,datosTapa[i].usuario.correoElectronico,datosTapa[i].comentario))
                } 
            }
        }
    });

    XHR3.open('GET',URL3, false);
    XHR3.send();

    notaMedia = notaMedia/datosTapa.length;
    console.log(notaMedia)
    document.querySelector("#valoracionMedia p").textContent = "Valoración media de la tapa: "+parseFloat(notaMedia.toFixed(2));

    let nombreUsuario = getCookie("usuario");
    if (nombreUsuario == "admin") {
        btnQR = document.querySelector("#btnGenerarQR");
        btnQR.style.display = "block";
        btnQR.addEventListener('click',function() {
            generarCodigoQR(datosTapa.codigo);
        })
    }

    if (nombreUsuario == null) {
        divComentar = document.querySelector("#nuevoComentario");
        divComentar.style.display = "none";
    }
})

function generarFicha(datos) {
    let html = "";
    html += `<article><img class='imgTapa' src='../imagenes/tapas/${datos.nombre}.jpeg'><h1>${datos.nombre}</h1><p>${datos.descripcion}</p><p>${datos.igredientes}</p></div></article>`
    return html;
}

function generarComentario(valoracion,usuario,comentario) {
    let div = document.createElement("div");
    let h3 = document.createElement("h3");
    h3.textContent = usuario;
    let divEstrellas = document.createElement("div");
    for (i=0;i<valoracion;i++) {
        let imagen = document.createElement("img");
        imagen.src = "../imagenes/valoracion/estrella.png";
        imagen.classList.add("imagenEstrella")
        divEstrellas.appendChild(imagen);
    }
    let p = document.createElement("p");
    p.textContent = comentario
    div.appendChild(h3);
    div.appendChild(divEstrellas);
    div.appendChild(p);
    let hr = document.createElement("hr");
    div.appendChild(hr);
    return div;
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

function generarCodigoQR(id) {
    let divPrincipal = document.querySelector("#contenedorPrincipal");
    while (divPrincipal.firstChild) {
        divPrincipal.removeChild(divPrincipal.firstChild);
    }
    new QRCode(divPrincipal,"http://127.0.0.1:5500/AccesoVotacion/registroVotacion.html?idTapa="+id);
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