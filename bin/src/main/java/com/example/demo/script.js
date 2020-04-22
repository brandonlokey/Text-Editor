async function getFileList(notes) {
    //const resp2 = fetch("http://127.0.0.1:8080/getBody?id=" + id);
		body = fetch("http://127.0.0.1:8080/getBody?id=" + "asdf");
		
		console.log("body = " + JSON.stringify(body) + " for ID " + "asdf");
}

getFileList();