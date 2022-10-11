function traerDatosCategoria(){
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        dataType: "json",
        success: function (resultado){
            pintarDatos(resultado);
        },
        error: function (resultado, xhr){
            alert("Error de peticion!");
        }

    })
}
function pintarDatos(Datos){
    let html="";
    html += "<tr>";
    Object.keys(datos[0]).forEach(CategoryPorEliminar =>{
        html+="<th>"+CategoryPorEliminar+"</th>"

    });
    html += "</tr>";

    for(let i=0; i<datos.length; i++){
        html += "<tr>";
        Object.values(datos[i]).forEach(CategoryPorEliminar =>{
            if (typeof (CategoryPorEliminar)=='object'){
                html+="<th>"+CategoryPorEliminar[0].name+"</th>"
            }else {
                html+="<td>"+CategoryPorEliminar+"</td>"
            }

        });
        html += "</tr>";
    }

    $("#tabla").empty();
    $("#tabla").append(html);

}
