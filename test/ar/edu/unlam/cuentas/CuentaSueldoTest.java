package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaSueldoTest {

	@Test
	public void queSePuedaDepositar() {
		CuentaSueldo cuenta = new CuentaSueldo();
		Boolean valorObtenido = cuenta.depositar(4_000.0);
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerElSaldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4_000.0);
		Double valorObtenido = cuenta.getSaldo();
		assertEquals(4_000.0, valorObtenido, 0.01);
	}
	
	@Test
	public void queSePuedaRealizarVaiasDepositosYObtenerElSaldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4_000.0);
		cuenta.depositar(4_000.0);
		Double valorObtenido = cuenta.getSaldo();
		assertEquals(8_000.0, valorObtenido, 0.01);
	}
	
	@Test
	public void queSePuedaExtraerConDineroSuficiente() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4_000.0);
		Boolean valorObtenido = cuenta.extraer(3_000.0);
		assertTrue(valorObtenido);
		assertEquals(1_000.0, cuenta.getSaldo(), 0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerConDineroInsuficiente() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4_000.0);
		Boolean valorObtenido = cuenta.extraer(4_000.1);
		assertFalse(valorObtenido);
	}
	

}
