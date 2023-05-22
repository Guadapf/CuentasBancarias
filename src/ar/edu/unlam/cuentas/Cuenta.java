package ar.edu.unlam.cuentas;

public abstract class Cuenta {
	protected Double saldo = 0.0;
	
	public Boolean depositar(Double monto) {
		this.saldo += monto;
		return true;
	}
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	public abstract Boolean extraer(Double monto);

}
