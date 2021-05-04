'use strict'
{
    class DeltagerValidering{
        constructor(rootID){   
            this.rootID = rootID;
            this.run = this.run.bind(this);
            this.validerSkjema = this.validerSkjema.bind(this);
        }

        run() {
            this.rootElement = document.getElementById(this.rootID);
            this.rootElement.querySelector('button[type=submit]').addEventListener('click', this.validerSkjema);
        }

        validerSkjema(event){
            let fornavnGyldig = fornavnGyldigVerdi.test(this.rootElement.querySelector('input[name=fornavn]').value.trim());
            let etternavnGyldig = etternavnGyldigVerdi.test(this.rootElement.querySelector('input[name=etternavn]').value.trim());
            let mobilGyldig = mobilGyldigVerdi.test(this.rootElement.querySelector('input[name=mobil]').value.trim());
            let passordVerdi = this.rootElement.querySelector('input[name=passord]').value.trim();
            let passordGyldig = passordGyldigVerdi.test(passordVerdi);
            let passordRepetertGyldig = passordGyldig && ((this.rootElement.querySelector('input[name=passordRepetert]').value.trim()) === passordVerdi);
            let kjonnGyldig = this.rootElement.querySelector('input[value=mann]').checked || this.rootElement.querySelector('input[value=mann]').checked;
            let feilmelding = this.rootElement.querySelector('div[data-info="submit"]');
            

            if(fornavnGyldig && etternavnGyldig && mobilGyldig && passordGyldig && passordRepetertGyldig){
                if(confirm('Send info til tjener!')){
                    //OK!
                }else{
                    feilmelding.innerHTML = 'Påmelding avbrutt av bruker.';
                    feilmelding.classList.remove('formcontroller_hidden');
                    event.preventDefault();
                }
            }else{
                feilmelding.classList.remove('formcontroller_hidden');
                if(!fornavnGyldig)feilmelding.innerHTML = 'Fornavn er feil utfylt  <br /> ';
                if(!etternavnGyldig)feilmelding.innerHTML += 'Etternavn er feil utfylt <br />';
                if(!mobilGyldig)feilmelding.innerHTML += 'Mobil er feil utfylt. Må inneholde 8 siffer.<br />';
                if(!passordGyldig)feilmelding.innerHTML += 'Passord må inneholde 6 tegn, men bør ha 13+.<br />';
                if(!passordRepetertGyldig)feilmelding.innerHTML += 'Repetert passord må være likt oppgitt passord<br />';
                if(!kjonnGyldig)feilmelding.innerHTML += 'Kjønn må velges';
                
                event.preventDefault();
            }
            
        }

    }
    const fornavnGyldigVerdi = RegExp('^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ ]{1,19}$');
    const etternavnGyldigVerdi = RegExp('^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{1,19}$');
    const mobilGyldigVerdi = RegExp('^[0-9]{8}$');
    const passordGyldigVerdi = RegExp('^.{6}');
    const form = new DeltagerValidering('root');
    document.addEventListener('DOMContentLoaded', form.run);
}