package concessionaria;

public class Modelo {

	public static void main(String[] args) {

		Carro Ferrari = new Carro();
		Ferrari.ano = 2005;
		Ferrari.cor = "Branco";
		System.out.println("Ferrari");
		System.out.println("Cor do carro: " + Ferrari.cor  );
		System.out.println("Ano: " + Ferrari.ano);
		
		Ferrari.ligar();
		
		Ferrari.acelerar();
		
		Ferrari.deligar();
		
		

		Carro Fusca = new Carro();
		Fusca.ano = 2005;
		Fusca.cor = "Branco";
		System.out.println("Ferrari");
		System.out.println("Cor do carro: " + Fusca.cor  );
		System.out.println("Ano: " + Fusca.ano);
		
		Fusca.ligar();
		
		Fusca.acelerar();
		
		Fusca.deligar();
				
	}
}