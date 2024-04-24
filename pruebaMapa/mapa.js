var map;
    
function initMap() {
     map = new google.maps.Map(document.getElementById('map'), {
       center: {lat: 38.09570178155309, lng: -3.7767699702989996},
       zoom: 15,
       maxZoom: 17
     });

     var marker = setMarca(38.09657699302153,-3.7773277767323212,"1","restaurante.png");
     var marker2 = setMarca(38.094192413958794, -3.777303361385857,"2","restaurante.png");
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
        console.log(this.title)
        window.location.href = "../votacion/votacion.html?idTapa="+this.title;
    });;
}
