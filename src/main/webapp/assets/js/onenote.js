function onenote(noteid){
            var xhr = new XMLHttpRequest();
            xhr.open("GET", 'rest/note/onenote', true);

            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            xhr.setRequestHeader("Session-token", getCookie("token"));
            xhr.setRequestHeader("Note-id", noteid);

            xhr.onreadystatechange = function () {
                if (xhr.readyState == XMLHttpRequest.DONE) {
                    if (xhr.status !== 500) {
                        var jsonObject = JSON.parse(xhr.responseText);

                        console.log(jsonObject)
                        var newText  = document.createTextNode(jonObject.id);
                        alert(jonObject.title);
                        
                    } else {
                        //alert("Błąd logowania");
                    }
                } else {
                    //alert("Błąd logowania");
                }
            }

            xhr.send();




            function getCookie(name) {
                var value = "; " + document.cookie;
                var parts = value.split("; " + name + "=");
                if (parts.length == 2)
                    return parts.pop().split(";").shift();
            }
            }

