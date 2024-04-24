const XHR = new XMLHttpRequest();

addEventListener('DOMContentLoaded',function() {
    let URL = "http://localhost:9093/gestion/establecimientos";
    XHR.addEventListener('load',function() {
        datos = JSON.parse(XHR.responseText);     
        console.log(datos)   
        let contenedorEstablecimientos = document.querySelector("#divEstablecimientos");
        //contenedorEstablecimientos.appendChild(generarTabla(datos));
        
        contenedorEstablecimientos.innerHTML = generarFicha(datos);
    })
    XHR.open('GET',URL, false);
    XHR.send();

    let botones = document.querySelectorAll("article button");
    if (botones) {
        for (i=0;i<botones.length;i++) {
            botones[i].addEventListener('click',function(){
                console.log(this.dataset.tapa)
                window.location.replace("../tapas/tapa.html?idTapa="+this.dataset.tapa);

            })
        }
    }

    let usuario = document.querySelector("#usuarioLI");
    usuario.innerHTML += " "+getCookie("usuario")

    if (getCookie("usuario") == "") {
        liLogeado = document.getElementsByClassName("logeado");
        console.log(liLogeado);
        for (i=0;i<liLogeado.length;i++) {
            liLogeado[i].style.display = 'none';
        }
    } else {
        liLogearse = document.getElementsByClassName("logearse");
        console.log(liLogearse);
        for (i=0;i<liLogearse.length;i++) {
            liLogearse[i].style.display = 'none';
        }
    } 

    let menu = document.querySelector("#checkMenu");
    let elementMenu = document.querySelector("#ElementosMenu");
    let altoMenu = document.querySelector(".menu");
    if (!menu.checked) {
        elementMenu.style.display = 'none';
        altoMenu.style.height = "200px"
    }
    menu.addEventListener('change',function() {
        if (menu.checked) {
            elementMenu.style.display = '';
            altoMenu.style.height = "100%"
            bloquearPantalla();
        } else {
            elementMenu.style.display = 'none';
            altoMenu.style.height = "200px"
            desbloquearPantalla();
        }
    })
});

function generarTabla(arrayObjetos) {
    let tabla = document.createElement("table");
    let keys = Object.keys(arrayObjetos[0]);

    let filaTitulos = document.createElement("tr");
    for (let i=0;i<keys.length;i++) {
        let th = document.createElement("th");
        th.textContent = keys[i];
        filaTitulos.appendChild(th)
    }
    tabla.appendChild(filaTitulos);

    for (objeto of arrayObjetos) {
        let tr = document.createElement("tr");
        for (let i=0;i<keys.length;i++) {
            let td = document.createElement("td");
            td.textContent = objeto[keys[i]];
            tr.appendChild(td)
        }
        tabla.appendChild(tr);
    }
    return tabla;
}

function generarFicha(datos) {
    let html = "";
    for (i=0;i<datos.length;i++) {
        if (datos[i].tapa != null) {
            html += `<article><div class='contenedor'><img src='../imagenes/piñero.webp'><h1 class='centrado'>${datos[i].nombre}</h1><p class='esconder'>${datos[i].descripción}</p><p class='esconder'>${datos[i].dirección}</p><button class='boton' data-tapa='${datos[i].tapa.codigo}'>Ver tapa</button></div></article>`
        } else {
            html += `<article><div class='contenedor'><img src='../imagenes/piñero.webp'><h1 class='centrado'>${datos[i].nombre}</h1><p class='esconder'>${datos[i].descripción}</p><p class='esconder'>${datos[i].dirección}</p>`
        }
    }
    return html;
}

function setCookie (clave,valor) {
    document.cookie = clave+"="+valor+";SameSite=Lax";
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

function bloquearPantalla() {
    document.body.classList.add('no-scroll');
  }

  function desbloquearPantalla() {
    document.body.classList.remove('no-scroll');
  }