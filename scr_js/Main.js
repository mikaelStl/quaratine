const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');

const keys = {
    up: 'w',
    down: 's',
    right: 'd',
    left: 'a',

    interact: 'f',
    reload: 'r',
    cure: 'q'
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

function start() {
    window.requestAnimationFrame(start);
    
    c.drawImage(back, 0, 0);

    if (player.moving) {
        player.draw(c, 'walk');
    } else {
        player.draw(c, 'standart');
    }

    // if (!shooting) {
    //     weapon.draw(c, 'standart');
    // } else {
    //     weapon.draw(c, 'shooting');
    // }

    for (const zombie of zombies) {
        zombie.draw(c, 'standart');
        zombie.walkX(player);
        zombie.walkY(player);
    }

    player.weapon.draw(c, 'standart');
}
start();