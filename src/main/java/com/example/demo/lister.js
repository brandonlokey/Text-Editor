// Returns JSON of file names and lists them in unordered list *unordered list not functional*

async function getFileList(notes) {
    const resp = await fetch("http://127.0.0.1:8080/getFiles");
    notes = await resp.json();
    console.log(notes);

    var list = document.createElement('ul');

    listContainer = document.createElement('div');
    listElement = document.createElement('ul');
    numItems = notes.length;

    document.getElementsByTagName('body')[0].appendChild(listContainer);
    listContainer.appendChild(listElement);

    for (var i = 0; i <numItems; ++i) {
        listItem = document.createElement('li');

        listItem.innerHTML = notes[i];
    }
}

getFileList();

/*async function makeList() {
    var list = document.createElement('ul');

    for(var i = 0; i < filenames.length; i++) {
        // Create the list item:
        var item = document.createElement('li');

        // Set its contents:
        item.appendChild(document.createTextNode(array[i]));

        // Add it to the list:
        list.appendChild(item);
    }

    // Finally, return the constructed list:
    return list;
}*/