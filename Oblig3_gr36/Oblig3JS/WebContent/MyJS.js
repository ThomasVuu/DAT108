'use strict';
{
	class DiceController {

		constructor(root = null) {
			this.root = root;
			this.run = this.run.bind(this);
			this.rollDice = this.rollDice.bind(this);
		}
		run() {
			let btRef = document.getElementById(this.root).querySelector("*[data-dicebutton]");
			btRef.addEventListener("click", this.rollDice, true);

		}

		rollDice() {
			let dice1 = new Dice;
			dice1.roll();
			document.getElementById("data-diceoutput").innerHTML = dice1.value;
		}
	}
	class Dice {

		constructor() {
			this.value = 0
		}

		roll() {
			this.value = Math.floor((Math.random() * 6) + 1);
		}
	}
	const controller = new DiceController('root');
	document.addEventListener('DOMContentLoaded', controller.run, true);

}











