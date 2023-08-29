const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');

const body = document.querySelector('body');
const WIDTH = body.clientWidth;
const HEIGHT = body.clientHeight;

const keys = {
    up: 'w',
    down: 's',
    right: 'd',
    left: 'a',

    interact: 'f',
    reload: 'r',
    cure: 'q'
}

canvas.width = WIDTH;
canvas.height = HEIGHT;

// const scaledCanvas = {
//     width: canvas.width / 4,
//     height: canvas.height / 4,
// }

const back = new Image();
back.src = './img/background.png';

const spawn = new Spawn(0, 0, 230, 320, 2);
const zombies = [];
spawn.spawnZombie(zombies);

const player = new Player({
    standart: new Sprite('./img/idle.png', 2, 48),
    standartL: new Sprite('./img/idle-l.png', 2, 48),
    // walk: new Sprite('./img/walk.png', 8, 8)
});

function colider() {
    for (const shot of player.weapon.shots) {
        for (const zombie of zombies) {
            if(Entity.touch(shot, zombie)){
                shot.hit(zombie);
                if (zombie.dead) {
                    zombies.splice(zombies.indexOf(zombie, 0), 1);
                }
                player.weapon.shots.splice(player.weapon.shots.indexOf(shot, 0), 1);
            }
        }
    }
}

// void checkColision(){

//     for (int m = 0; m < shots.size(); m++) {
//         Shot shot = shots.get(m);
//         shotBox = shot.getBounds();
//         for (int s = 0; s < enemies.size(); s++) {
//             Zombie zombie = enemies.get(s);
//             if (shotBox.intersects(zombie.getBounds())) {
//                 shot.hitZombie(zombie);
//                 if (zombie.getLife() <= 0) {
//                     if (zombie.getItem() != null) {
//                         items.add(Spawn.spawnItem(zombie));
//                     }
//                     enemies.remove(zombie);
//                 }
//                 shots.remove(shot);
//             }
//         }
//     }

//     for (int f = 0; f < items.size(); f++) {
//         Item item = items.get(f);
//         if (item != null) {
//             item.getBounds();
//             if (Entity.touch(player, item)) {
//                 player.addItem(item);
//                 items.remove(f);
//             }
//         }
//     }
// }

function start() {
    window.requestAnimationFrame(start);

    c.clearRect(0, 0, WIDTH, HEIGHT);
    
    spawn.draw();
    
    // c.drawImage(back, 0, 0);

    for (const shot of player.weapon.shots) {
        shot.draw(c, 'standart');
        shot.move();
    }

    // if (player.moving) {
    //     player.draw(c, 'walk');
    // } else {
        player.draw(c, 'standart');
    // }

    if (!player.weapon.shooting) {
        player.weapon.draw(c, 'standart');
    } else {
        player.weapon.draw(c, 'shoot');
    }

    for (const zombie of zombies) {
        zombie.draw(c, 'standart');
    }
    colider();
}
start();