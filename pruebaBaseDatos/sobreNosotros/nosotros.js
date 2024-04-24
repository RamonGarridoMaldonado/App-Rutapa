const XHR = new XMLHttpRequest();
const XHR2 = new XMLHttpRequest();

addEventListener('DOMContentLoaded',function() {
    let URL = "http://localhost:9093/gestion/informacion";
    XHR.addEventListener('load',function() {
        datos = JSON.parse(XHR.responseText);        
        document.querySelector("#titulo").textContent = datos[0].titulo
        document.querySelector("#descripcion").textContent = datos[0].descripcion
    })
    XHR.open('GET',URL, false);
    XHR.send();

    let nuevoTitulo = document.querySelector("#introducirNuevoTitulo");
    let nuevaDescripcion = document.querySelector("#introducirNuevaDescripcion");
    let btnActualizar = document.querySelector("#botonEnviarInformacion");

    if (getCookie("usuario") == "admin") {
        btnActualizar.addEventListener('click',function() {
            let nuevaInformacion = {
                titulo: nuevoTitulo.value,
                descripcion: nuevaDescripcion.value 
            }
            let post = JSON.stringify(nuevaInformacion);
            console.log(post)
            const urlPost = "http://localhost:9093/gestion/informacion/1"
            let xhrPost = new XMLHttpRequest();
            xhrPost.open('PUT', urlPost, true);
            xhrPost.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
            xhrPost.send(post);
            xhrPost.onload = function () {
                if(xhrPost.status === 200) {
                    console.log ("Se ha cambiado la informacion")
                    location.reload();
                }
            }
        })
    } else {
        nuevoTitulo.style.display = "none";
        nuevaDescripcion.style.display = "none";
        btnActualizar.style.display = "none";
    }
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