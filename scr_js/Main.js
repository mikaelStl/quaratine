const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');

const keys = {
    up: 'w',
    down: 's',
    right: 'd',
    left: 'a'
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
// Spawn.spawnZombie(zombies);

const player = new Player({
    standart: new Sprite('./img/idle.png', 2, 48),
    walk: new Sprite('./img/walk.png', 8, 8)
});
// console.log(player);

function start() {
    window.requestAnimationFrame(start);

    c.drawImage(back, 0, 0);

    // if (player.moving) {
        player.draw(c, 'walk');
    // } else {
    //     player.draw(c, 'standart');
    // }

    for (const zombie of zombies) {
        zombie.draw(c);
        zombie.walkX(player);
        zombie.walkY(player);
    }
}
start();

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
// window.addEventListener('click', (evt) =>{
//     console.log('atirou');
// })