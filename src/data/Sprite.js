/**
 * Classe para criação de Sprites/Animações para os objetos;
 */
class Sprite{
    /**
     * 
     * @param {string} path - diretório da imagem;
     * @param {number} f - quantidade de frames da imagem;
     * @param {number} r - total de frames por segundo da animação;
     */
    constructor(path=String(), f=Number(), r=Number()){
        this.src = path;
        this.frames = f;
        this.rate = r;
        this.current = 0;
        this.elapsed = 0;
    }

    animate(){
        this.elapsed++;

        if (this.elapsed % this.rate === 0) {
            if (this.current < (this.frames - 1)) {
                this.current++;
            } else {
                this.current = 0;
            }
        }
    }
}