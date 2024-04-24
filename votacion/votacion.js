addEventListener("DOMContentLoaded",function() {
    let parametrosURL = ObtenerParametrosURL(window.location.href)
    if (Object.keys(parametrosURL).includes("idTapa")) {
        console.log(true);
        let idTapa = parametrosURL.idTapa;
        console.log(idTapa)
    }
})

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