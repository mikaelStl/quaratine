const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
const fps = 24;

const keys = {
    up: 38,
    down: 40,
    right: 39,
    left: 37
}

canvas.width = 640;
canvas.height = 640;

// const scaledCanvas = {
//     width: canvas.width / 4,
//     height: canvas.height / 4,
// }

const back = new Image();
back.src = './img/background.png';

// const ent = new Entity('./img/walk.png', frames = {max: 7, current: 0, elapsed: 0});
const ent = new Entity('./img/idle.png', frames = {max: 6, current: 0, elapsed: 0});

function start() {
    window.requestAnimationFrame(start);

    c.drawImage(back, 0, 0);
    ent.draw(c);
}
start();

window.addEventListener('keydown', (evt)=>{
    switch (evt.keyCode) {
        case keys.up: ent.move(evt);
            break;
        case keys.down: ent.move(evt);
            break;
        case keys.right: ent.move(evt);
            break;
        case keys.left: ent.move(evt);
            break;
    }
});

window.addEventListener('keyup', (evt)=>{
    switch (evt.keyCode) {
        case keys.up: ent.stop();
            break;
        case keys.down: ent.stop();
            break;
        case keys.right: ent.stop();
            break;
        case keys.left: ent.stop();
            break;
    }
});