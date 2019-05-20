$("#getButton").click(function () {
    var file_name = $("#file_name").val();
    $.get("http://localhost:8080/stat?file_name="+file_name,function (data) {

        setArrayToTable(data);
    })

});

function setArrayToTable(array) {

    $("#stat_table").find("tr:not(:first)").remove();
    array.forEach(function (element) {
        var row = "<tr>";
        for (var property in element){
            row += "<td>" + element[property] + "</td>";
        }
        row += "</tr>";

        $("#stat_table").append(row);
    });
}