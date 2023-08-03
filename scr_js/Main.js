const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
const fps = 24;

const keys = {
    up: 87,
    down: 83,
    right: 68,
    left: 65
}

canvas.width = 640;
canvas.height = 640;

// const scaledCanvas = {
//     width: canvas.width / 4,
//     height: canvas.height / 4,
// }

const back = new Image();
back.src = './img/background.png';

const spawn = new Spawn();
const zombies = [];
Spawn.spawnZombie(zombies);
// console.log(zombies);

const player = new Player('./img/idle.png', frames = {max: 4, current: 0, elapsed: 0});

const img = new Image();
img.src = './img/idle.png';

function start() {
    window.requestAnimationFrame(start);

    c.drawImage(back, 0, 0);
    player.draw(c);

    for (const zombie of zombies) {
        zombie.draw(c);
        zombie.walkX(player);
        zombie.walkY(player);
    }
}
start();

window.addEventListener('keydown', (evt)=>{
    switch (evt.keyCode) {
        case keys.up: player.move(evt);
            break;
        case keys.down: player.move(evt);
            break;
        case keys.right: player.move(evt);
            break;
        case keys.left: player.move(evt);
            break;
    }
});

window.addEventListener('keyup', (evt)=>{
    switch (evt.keyCode) {
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
// window.addEventListener('click', (evt) =>{
//     console.log('atirou');
// })