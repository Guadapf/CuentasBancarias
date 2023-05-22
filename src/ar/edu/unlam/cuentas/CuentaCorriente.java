package ar.edu.unlam.cuentas;

public class CuentaCorriente extends Cuenta{

	private Double descubierto;
	private final Double DESCUENTO = 0.05;
	
	public CuentaCorriente(Double descubierto) {
		this.descubierto = descubierto;
	}
	
	@Override
	public Boolean extraer(Double monto) {
		
		if(monto <= super.getSaldo() + this.descubierto) {
			Double comision = this.descubierto * this.DESCUENTO;
			super.saldo -= (monto + comision);
			return true;
		}
		return false;
	}

}
