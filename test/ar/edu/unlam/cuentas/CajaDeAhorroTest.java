package ar.edu.unlam.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaDeAhorroTest {

	@Test
	public void queSePuedaDepositar() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		Boolean valorObtenido = cuenta.depositar(4_000.0);
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerElSaldo() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(4_000.0);
		Double valorObtenido = cuenta.getSaldo();
		assertEquals(4_000.0, valorObtenido, 0.01);
	}
	
	@Test
	public void queSePuedaRealizarVaiasDepositosYObtenerElSaldo() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(4_000.0);
		cuenta.depositar(4_000.0);
		Double valorObtenido = cuenta.getSaldo();
		assertEquals(8_000.0, valorObtenido, 0.01);
	}
	
	@Test
	public void queSePuedaExtraerConDineroSuficiente() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(4_000.0);
		Boolean valorObtenido = cuenta.extraer(3_000.0);
		assertTrue(valorObtenido);
		assertEquals(1_000.0, cuenta.getSaldo(), 0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerConDineroInsuficiente() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(4_000.0);
		Boolean valorObtenido = cuenta.extraer(4_000.1);
		assertFalse(valorObtenido);
	}
	
	@Test
	public void queCobreComisionDespuesDeLaQuintaExtraccion() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(4_000.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		Double valorObtenido = cuenta.getSaldo();
		assertEquals(3_934.0, cuenta.getSaldo(), 0.01);
	}
	
	@Test
	public void queNoSePuedaExtraerDespuesDeLaQuintaExtraccionSiNoPuedeRealizarElDescuento() {
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(60.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		cuenta.extraer(10.0);
		assertFalse(cuenta.extraer(10.0));
		assertEquals(10.0,cuenta.getSaldo(),0.01);
	}

}
