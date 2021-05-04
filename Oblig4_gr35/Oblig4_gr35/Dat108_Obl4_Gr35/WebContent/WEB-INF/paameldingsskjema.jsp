<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="no">
  <head>
  <meta charset="UTF-8">
    <link rel="shortcut icon" href="#">
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/formcontroller.css" rel="stylesheet" type="text/css" />
    <script src="js/validator.js" defer></script>
    <script src="js/formcontroller.js" defer></script>

    <title>Påmelding</title>
  </head>
  <body>
    <h2>Påmelding</h2>

    <div id="root">
      <form method="post">
        <fieldset>
          <label for="fornavn">Fornavn:</label> <input type="text" name="fornavn" id="fornavn" value="${skjema.fornavn}" />
          <span class="melding">${skjema.fornavnFeilmelding}</span>

          <label for="etternavn">Etternavn:</label> <input type="text" name="etternavn" id="etternavn" value="${skjema.etternavn}" />
          <span class="melding">${skjema.etternavnFeilmelding}</span>

          <label for="mobil">Mobil (8 siffer):</label> <input type="text" name="mobil" id="mobil" value="${skjema.mobil}" />
          <span class="melding">${skjema.mobilFeilmelding}</span>

          <label for="passord">Passord:</label> <input type="password" name="passord" id="passord" value="${skjema.passord}" />
          <span class="melding">${skjema.passordFeilmelding}</span>

          <label for="passordRepetert">Passord repetert:</label> <input type="password" name="passordRepetert" id="passordRepetert" value="${skjema.passordRepetert}" />
          <span class="melding">${skjema.passordRepetertFeilmelding}</span>

          <span class="columnfirst">Kjønn:</span>
          <span data-kjonn>
            <label><input type="radio" name="kjonn" value="mann" ${skjema.kjonn eq "mann" ? "checked=\"checked\"" : ""} /> mann</label>
            <label><input type="radio" name="kjonn" value="kvinne" ${skjema.kjonn eq "kvinne" ? "checked=\"checked\"" : ""} />kvinne</label>
          </span>
          <span class="melding">${skjema.kjonnFeilmelding}</span>

          <button type="submit">Meld meg på</button>
        </fieldset>
      </form>
        <div data-info="passord"></div>
        <div data-info="submit"></div>
    </div>
  </body>
</html>