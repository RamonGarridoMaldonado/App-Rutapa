const XHR3 = new XMLHttpRequest();
const XHR = new XMLHttpRequest();
numeroComentarios = 0;

addEventListener('DOMContentLoaded',function() {
    let URL3 = "http://localhost:9093/gestion/valoraciones/";
    let divComentarios = document.querySelector("#historialComentarios");
    XHR3.addEventListener('load',function() {
        datosComentarios = JSON.parse(XHR3.responseText);
        for (let i=0;i<datosComentarios.length;i++) {
            if (datosComentarios[i].usuario.correoElectronico == getCookie("usuario")) {
                console.log(datosComentarios[i])
                numeroComentarios++;
                divComentarios.appendChild(generarComentario(datosComentarios[i].valoracion,datosComentarios[i].tapa.nombre,datosComentarios[i].comentario,datosComentarios[i].tapa.nombre))
            }
        }
    });

    XHR3.open('GET',URL3, false);
    XHR3.send();

    h1Usuario = document.querySelector("#h1CorreoElectrónico");
    h1Usuario.textContent = getCookie("usuario");

    let URL = "http://localhost:9093/gestion/establecimientos";
    XHR.addEventListener('load',function() {
        datosEstablecimientos = JSON.parse(XHR.responseText);        
    })
    XHR.open('GET',URL, false);
    XHR.send();

    let primeraMedalla = document.querySelector("#medallaPrimeraValoracion");
    let segundaMedalla = document.querySelector("#medallaCalificaMitad");
    let terceraMedallas = document.querySelector("#medallaCalificaTodos");
    let pInfoMedalla = document.querySelector("#informacionMedalla");

    if (numeroComentarios < 1) {
        quitarTransparencia(primeraMedalla);
    } 

    if (numeroComentarios < (datosEstablecimientos.length / 2)) {
        quitarTransparencia(segundaMedalla);
    }

    if (numeroComentarios < datosEstablecimientos.length) {
        quitarTransparencia(terceraMedallas);
    }

    primeraMedalla.addEventListener('click',function() {
        vaciarMarcado(new Array(primeraMedalla,segundaMedalla,terceraMedallas))
        ponerMarcado(this)
        pInfoMedalla.textContent = "¡Valora tu primera tapa!"
    });

    segundaMedalla.addEventListener('click',function() {
        vaciarMarcado(new Array(primeraMedalla,segundaMedalla,terceraMedallas))
        ponerMarcado(this)
        pInfoMedalla.textContent = "¡Valora la mitad de las tapas!"
    });

    terceraMedallas.addEventListener('click',function() {
        vaciarMarcado(new Array(primeraMedalla,segundaMedalla,terceraMedallas))
        ponerMarcado(this)
        pInfoMedalla.textContent = "¡Valora todas las tapas!"
    });
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

function generarComentario(valoracion,usuario,comentario,tapa) {
    let div = document.createElement("div");
    let img = document.createElement("img")
    img.src = "../imagenes/tapas/"+tapa+".jpeg";
    img.classList.add("imgTapa");
    let div2 = document.createElement("div");
    div2.classList.add("contenidoTapa");
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
    div.appendChild(div2)
    div.appendChild(img)
    div2.appendChild(h3);
    div2.appendChild(divEstrellas);
    div2.appendChild(p);
    let hr = document.createElement("hr");
    div.appendChild(hr);
    return div;
}

function quitarTransparencia(imagen) {
    imagen.style.opacity = "0.2";
    imagen.style.filter  = 'alpha(opacity=20)';
}

function ponerMarcado(imagen) {
    imagen.classList.add("marcado")
}

function vaciarMarcado(imagenes) {
    for (i=0;i<imagenes.length;i++) {
        imagenes[i].classList.remove("marcado")
    }
}