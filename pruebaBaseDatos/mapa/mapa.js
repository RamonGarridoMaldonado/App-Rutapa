var map;
const XHR = new XMLHttpRequest();
    
addEventListener('DOMContentLoaded',function() {
  let URL2 = "http://localhost:9093/gestion/establecimientos/";
     XHR.addEventListener('load',function() {
         datosTapa = JSON.parse(XHR.responseText);
         console.log(datosTapa);

        for (i=0;i<datosTapa.length;i++) {
          if (datosTapa[i].tapa != null) {
            var marker = setMarca(parseFloat(datosTapa[i].lat),parseFloat(datosTapa[i].lng),datosTapa[i].tapa.codigo.toString(),"restaurante.png");
          } else {
            var marker = setMarca(parseFloat(datosTapa[i].lat),parseFloat(datosTapa[i].lng),datosTapa[i].codigo.toString(),"restaurante.png");
          }
        }
     });
 
     XHR.open('GET',URL2, false);
     XHR.send();
})

function initMap() {
     map = new google.maps.Map(document.getElementById('map'), {
       center: {lat: 38.09570178155309, lng: -3.7767699702989996},
       zoom: 15,
       maxZoom: 17
     });
}

function setMarca(latMarca,lngMarca,titulo,icono) {
    let icon = {
      url: icono,
      scaledSize: new google.maps.Size(50, 50),
    };

    new google.maps.Marker({
        position: {lat: latMarca, lng: lngMarca},
        map: map,
        title: titulo,
        icon: icon
    }).addListener('click', function() {
        setCookie("tapa_id",this.title);
        window.location.href = "../tapa.html?idTapa="+this.title;
    });;
}

function setCookie (clave,valor) {
  console.log(valor);
  document.cookie = clave+"="+valor+";SameSite=Lax";
}

function deleteAllCookies() {
  const cookies = document.cookie.split(";");

  for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i];
      const eqPos = cookie.indexOf("=");
      const name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
      document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
  }
}