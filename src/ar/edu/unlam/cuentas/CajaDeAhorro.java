package ar.edu.unlam.cuentas;

public class CajaDeAhorro extends Cuenta {
	
	private Integer contador = 0;

	public Boolean extraer(Double monto) {
		
		Integer descuento = 6;
		Double montoConDescuento = monto + descuento;
		
		if(this.saldo >= monto && this.contador < 5) {
			this.saldo = this.saldo - monto;
			this.contador++;
			return true;
		}else if(this.contador >= 5 && this.saldo >= (monto+descuento)) {
			this.saldo = this.saldo - montoConDescuento;
			this.contador++;
			return true;
		}
		return false;
	}

}
