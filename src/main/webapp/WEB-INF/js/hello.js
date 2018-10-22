$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/hello"
    }).then(function(data) {
       $('.title').append(data.title);
       $('.numberHours').append(data.numberHours);
       $('.isActive').append(data.isActive);
       $('.level').append(data.level);
    });
});