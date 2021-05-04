'use strict'
{
    class FormController {

        constructor(rootElement) {
            this.root = rootElement;
            this.changeClass = this.changeClass.bind(this);
            this.validateRepeatedPassword = this.validateRepeatedPassword.bind(this);

            const self = this;
            const fornavn = this.root.querySelector('input[name=fornavn');
            const etternavn = this.root.querySelector('input[name=etternavn');
            const mobil = this.root.querySelector('input[name=mobil');
            const passord = this.root.querySelector('input[name=passord');
            const passordRepetert = this.root.querySelector('input[name=passordRepetert');
        
            const passordStyrke = this.root.querySelector('div[data-info="passord"]');
            passordStyrke.classList.add('formcontroller_hidden');
            this.root.querySelector('div[data-info="submit"]').classList.add('formcontroller_hidden');

            passord.addEventListener('mouseover', function () {
                passordStyrke.textContent = 'Svakt passord: 6-8 tegn. Middels: 9-12 tegn. Sterkt: 13+ tegn.';
                passordStyrke.classList.remove('formcontroller_hidden');
            });

            passord.addEventListener('mouseout', function () {
                passordStyrke.textContent = '';
                passordStyrke.classList.toggle('formcontroller_hidden');
            });

            passord.addEventListener('input', this.validateRepeatedPassword)
            fornavn.addEventListener(
                'input',
                function (event) {
                    if (fornavnGyldig.test(fornavn.value.trim())) {
                        self.changeClass(event, 'formcontroller_validInput');
                    } else {
                        self.changeClass(event, 'formcontroller_invalidInput');
                    }
                });

            etternavn.addEventListener(
                'input',
                function (event) {
                    if (etternavnGyldig.test(etternavn.value.trim())) {
                        self.changeClass(event, 'formcontroller_validInput');
                    } else {
                        self.changeClass(event, 'formcontroller_invalidInput');
                    }
                });

            mobil.addEventListener(
                'input',
                function (event) {
                    if (mobilGyldig.test(mobil.value.trim())) {
                        self.changeClass(event, 'formcontroller_validInput');
                    } else {
                        self.changeClass(event, 'formcontroller_invalidInput');
                    }
                });


            passord.addEventListener(
                'input',
                function (event) {
                    if (sterktPassord.test(passord.value.trim())) {
                        self.changeClass(event, 'formcontroller_strongPassword');
                    } else if (middelsPassord.test(passord.value.trim())) {
                        self.changeClass(event, 'formcontroller_mediumPassword');
                    } else if (svaktPassord.test(passord.value.trim())) {
                        self.changeClass(event, 'formcontroller_weakPassword');
                    } else {
                        self.changeClass(event, 'formcontroller_invalidInput')
                    }
                });

            passordRepetert.addEventListener('input', this.validateRepeatedPassword);

        }
        validateRepeatedPassword() {
            let passord = this.root.querySelector('input[name=passord]');
            let passordRepetert = this.root.querySelector('input[name=passordRepetert]');
            passordRepetert.classList = null;
            if (passord.value.trim() !== "" && passord.value.trim() === passordRepetert.value.trim()) {
                passordRepetert.classList.add('formcontroller_validInput');
            } else if (passord.value.trim() !== "") {
                passordRepetert.classList.add('formcontroller_invalidInput');
            }
        }

        changeClass(event, className) {
            event.target.classList.remove(...event.target.classList);
            if (event.target.value.trim() !== "") {
                event.target.classList.add(className);
            }

        }


    }


    function init() {
        const rootElement = document.getElementById('root');
        new FormController(rootElement);
    }

    const fornavnGyldig = RegExp('^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ ]{1,19}$');
    const etternavnGyldig = RegExp('^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{1,19}$');
    const mobilGyldig = RegExp('^[0-9]{8}$');
    const svaktPassord = RegExp('^.{6,8}');
    const middelsPassord = RegExp('^.{9,12}');
    const sterktPassord = RegExp('^.{13}');

    document.addEventListener('DOMContentLoaded', init, true)
}