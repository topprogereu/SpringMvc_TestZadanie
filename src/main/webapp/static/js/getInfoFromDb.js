$("#getButton").click(function () {
    var file_name = $("#file_name").val();
    $.get("http://localhost:8080/stat?file_name="+file_name,function (data) {

        alert(data.toString());
    })

})