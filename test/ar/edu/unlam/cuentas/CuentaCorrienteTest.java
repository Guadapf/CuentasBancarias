package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	@Test
	public void queSePuedaDepositar() {
		CuentaCorriente c1 = new CuentaCorriente(150.0);
		assertTrue(c1.depositar(100.0));
	}
	
	@Test
	public void queSePuedaExtraerSinUtilizarElDescubierto() {
		CuentaCorriente c1 = new CuentaCorriente(0.0);
		
		c1.depositar(100.0);
		
		assertTrue(c1.extraer(100.0));
	}
	
	@Test
	public void queSePuedaExtraerUtilizandoElDescubierto() {
		CuentaCorriente c1 = new CuentaCorriente(150.0);
		
		c1.depositar(100.0);
		
		assertTrue(c1.extraer(200.0));
	}
	
	@Test
	public void queSeNouedaExtraerPorqueExcedeElDescubiertoYElSaldo() {
		CuentaCorriente c1 = new CuentaCorriente(150.0);
		
		c1.depositar(100.0);
		
		assertFalse(c1.extraer(300.0));
	}

}
