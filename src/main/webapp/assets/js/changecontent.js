function load_home() {
    document.location.href = "page.html";
    //document.getElementById("service").innerHTML = "";
    //document.getElementById("service").innerHTML = '<object type="text/html" data="home.html" style="width:100%; height: 100%;"></object>';
}
function load_add() {
    document.getElementById("service").innerHTML = "";
    document.getElementById("service").innerHTML = '<object type="text/html" data="add.html" style="width:100%; height: 100%;"></object>';
}
function load_manage() {
    document.getElementById("service").innerHTML = "";
    document.getElementById("service").innerHTML = '<object type="text/html" data="manage.html" style="width:100%; height: 100%;"></object>';
}
function load_search() {
    document.getElementById("service").innerHTML = "";
    document.getElementById("service").innerHTML = '<object type="text/html" data="search.html" style="width:100%; height: 100%;"></object>';
}
function load_remove() {
    document.getElementById("service").innerHTML = "";
    document.getElementById("service").innerHTML = '<object type="text/html" data="remove.html" style="width:100%; height: 100%;"></object>';
}
function load_note(content) {
    document.getElementById("service").innerHTML = "";
    document.getElementById("service").innerHTML = content;
    
    //document.getElementById("service").innerHTML = '<object type="text/html" data="note.html" style="width:100%; height: 100%;"></object>';
    //document.getElementById("notes").innerHTML = "";
    //document.getElementById("notes").innerHTML = content;
}
