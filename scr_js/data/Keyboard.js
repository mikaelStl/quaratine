window.addEventListener('contextmenu', (evt)=>{
    // evt.preventDefault();
});

let lastKey = '';
window.addEventListener('keydown', (evt)=>{
    switch (evt.key) {
        case keys.up: player.move(evt.key);
            break;
        case keys.down: player.move(evt.key);
            break;
        case keys.right: player.move(evt.key);
            break;
        case keys.left: player.move(evt.key);
            break;
    }
});

window.addEventListener('keyup', (evt)=>{
    switch (evt.key) {
        case keys.up: player.stop();
            break;
        case keys.down: player.stop();
            break;
        case keys.right: player.stop();
            break;
        case keys.left: player.stop();
            break;
    }
});

//to-do
window.addEventListener('mousedown', (evt) =>{
    switch (evt.buttons) {
        case 1: shooting = true;
            break;
        case 2: //mirar
            break;
    }
});
window.addEventListener('mouseup', (evt)=>{
    shooting = false;
});