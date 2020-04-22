const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);

if (urlParams.has('body')) {
    document.getElementById('body').innerHTML = urlParams.get('body');
	document.getElementById('curFile').value = urlParams.get('filename');
	console.log("Current file name: " +  urlParams.get('filename'));
}
