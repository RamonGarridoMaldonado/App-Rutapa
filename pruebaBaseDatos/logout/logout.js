addEventListener('DOMContentLoaded',function() {
    delete_cookie("usuario")
    window.location.replace("../index.html");
});

function delete_cookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  }