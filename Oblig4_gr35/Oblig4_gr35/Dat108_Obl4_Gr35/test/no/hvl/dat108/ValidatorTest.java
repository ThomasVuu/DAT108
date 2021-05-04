package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;



public class ValidatorTest {

	
	@Test
    public void validUsernamesShouldBeOk() {
        assertTrue(Validator.isValidUsername("12345678"));
        assertTrue(Validator.isValidUsername("88776644"));
        assertTrue(Validator.isValidUsername("11223344"));
        assertTrue(Validator.isValidUsername("98765432"));
        assertTrue(Validator.isValidUsername("00000001"));
	}
    
	@Test
	public void usernameWithIllegalCharsShouldNotBeOk() {
		assertFalse(Validator.isValidUsername("1234567T"));
        assertFalse(Validator.isValidUsername("-1234567"));
        assertFalse(Validator.isValidUsername("V?234567"));
        assertFalse(Validator.isValidUsername("v2234567"));
	}
    
    
    @Test
    public void wrongLengthUsernamesShouldNotBeOk() {
        assertFalse(Validator.isValidUsername(null));
        assertFalse(Validator.isValidUsername("1234567"));
        assertFalse(Validator.isValidUsername("123456789"));
        assertFalse(Validator.isValidUsername("12"));
    }
    
    
    
    @Test
    public void validFirstNamesShouldBeOk() {
        assertTrue(Validator.isValidFirstName("Jørn"));
        assertTrue(Validator.isValidFirstName("Stian"));
        assertTrue(Validator.isValidFirstName("Jon-Stian"));
        assertTrue(Validator.isValidFirstName("Kent Robin"));
    }
    
    @Test
    public void validLastNamesShouldBeOk() {
        assertTrue(Validator.isValidLastName("Stiansen"));
        assertTrue(Validator.isValidLastName("Olsen"));
        assertTrue(Validator.isValidLastName("Sundqvist"));
        assertTrue(Validator.isValidLastName("Anker-Hansen"));
    }
    
    
    @Test
    public void startingFirstNameWithLowerCaseIsNotOk() {
        assertFalse(Validator.isValidFirstName("henning"));
        
    }
    @Test
    public void illegalCharsInFirstNameIsNotOk() {
        assertFalse(Validator.isValidFirstName("He9ng"));
        assertFalse(Validator.isValidFirstName("F@jon"));
        
    }
    
    @Test
    public void startingLastNameWithLowerCaseIsNotOk() {
        assertFalse(Validator.isValidLastName("olsen"));
        
    }
    
    @Test
    public void spaceInLastNameIsNotOk() {
        assertFalse(Validator.isValidLastName("Anker Hansen"));
        
    }
    
    @Test
    public void norwegianLettersShouldBeAllowedInFirstAndLastName() {
        assertTrue(Validator.isValidFirstName("ÆØÅæøå"));
        assertTrue(Validator.isValidLastName("ÆØÅæøå"));
    }
    
    @Test
    public void wrongLengthPasswordIsNotOk() {
    	assertFalse(Validator.isValidPassword(null));
    	assertFalse(Validator.isValidPassword("1knas"));
    }
    
    @Test
    public void validPasswordIsOk() {
    	assertTrue(Validator.isValidPassword("1knas?2"));
    	assertTrue(Validator.isValidPassword("PASS?-1"));
    	assertTrue(Validator.isValidPassword("Gikk på tur i skogen"));
    	assertTrue(Validator.isValidPassword("Passord er vanskelig"));
    	assertTrue(Validator.isValidPassword("?@¨å2345.24<<"));
    }
    
    @Test
    public void validRepeatedPasswordIsOk() {
    	assertTrue(Validator.isValidRepeatedPassword("1knas?2", "1knas?2"));
    	assertTrue(Validator.isValidRepeatedPassword("?@¨å2345.24<<", "?@¨å2345.24<<"));
    	assertTrue(Validator.isValidRepeatedPassword("Gikk på tur i skogen", "Gikk på tur i skogen"));
    }
    
    @Test
    public void notMatchingRepeatedPasswordIsNotOk() {
    	
    	assertFalse(Validator.isValidRepeatedPassword("1knas?2", "knas?2"));
    	assertFalse(Validator.isValidRepeatedPassword("1knas?2", null));
    	assertFalse(Validator.isValidRepeatedPassword(null, "knas?2"));
    	assertFalse(Validator.isValidRepeatedPassword(null, null));
    	assertFalse(Validator.isValidRepeatedPassword("123456", "654321"));
    }
}
