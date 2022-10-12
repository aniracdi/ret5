function traerDatosCategoria(){
    $.ajax({
            url:"http://150.136.87.245:81/api/Category/all",
            type:"GET",
            datatype:"JSON",
            success: function(respuesta){
                pintarDatos(respuesta);
            },
            error: function (respuesta) {
                alert("Error de peticion!");
            }


        });
}

function pintarDatos(datos){
    let html="";
    html += "<tr>";
    Object.keys(datos[0]).forEach(elemento =>{
        html+="<th>"+elemento+"</th>";
    });
    html += "</tr>";

    $("#tabla").empty();
    $("#tabla").append(html);

}
