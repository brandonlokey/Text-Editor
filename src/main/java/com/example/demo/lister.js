// Returns JSON of file names and lists them in unordered list *unordered list not functional*

async function getFileList(notes) {
    const resp = await fetch("http://127.0.0.1:8080/getFiles");
    notes = await resp.json();
    console.log(notes);

    var list = document.createElement('ul');
    numItems = notes.length;

    notes.forEach(function (note)
    {
        var li = document.createElement('li');
        li.innerHTML = "<a href='index.html'>" + note + "</a>";
        list.appendChild(li);
    })
    var container = document.querySelector('#list');
    container.appendChild(list);
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