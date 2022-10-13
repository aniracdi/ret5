function traerDatosCategoria(items){
    $.ajax({
        url:"http://localhost:81/api/Category/all",
        type:"GET",
        dataType:"JSON",
        crossDomain: true,
        success: function(respuesta){
            pintarDatos(respuesta);
        },
        error: function (respuesta) {
            alert("Error de peticion!");
        }
    });
}

function traerDatosCostume(items){
    $.ajax({
        url:"http://localhost:81/api/Costume/all",
        type:"GET",
        dataType:"JSON",
        crossDomain: true,
        success: function(respuesta){
            pintarDatos(respuesta);
        },
        error: function (respuesta) {
            alert("Error de peticion!");
        }
    });
}

function pintarDatos(datos){
    if (datos.length > 0) {
        const keys = Object.keys(datos[0])
        let html = "<tr>";
        keys.forEach(elemento => {
            html += "<th>" + elemento + "</th>";
        });
        html += "</tr>";
        datos.forEach(item => {
            html += "<tr>";
            keys.forEach(key => {
                html += "<td>" + item[key] + "</td>";
            });
            html += "</tr>";
        });
        $("#table").html(html);
    }
}
