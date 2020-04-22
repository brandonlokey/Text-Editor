const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);

if(urlParams.has('filename')) {
    document.getElementById('curFile').innerHTML = urlParams.get('filename');
}
if (urlParams.has('body')) {
    document.getElementById('body').innerHTML = urlParams.get('body');
}