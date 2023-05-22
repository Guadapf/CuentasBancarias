package ar.edu.unlam.cuentas;

public class CuentaSueldo extends Cuenta{
	

	public Boolean extraer(Double monto) {
		
		if(this.saldo >= monto) {
			this.saldo -= monto;
			return true;
		}
		return false;
	}
	
	

}
