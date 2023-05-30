package br.cpm.estruturas.atividades;

public class Atividades02 {

	public static void main(String[] args) {

		int rs = 0;
		int[] valores = { 15, 35, 16, 82, 10, 26, 31, 47, 11, 19, 5, 13, 33, 51, 201, 200, 56 };
		int[] par, impar, multi3, multi4, multi5;

		for (int i = 1; i <= 9; i++) {
			System.out.println(valores[i]);
		}
		System.out.println("------------------------------------------------------------------------------");
		{
			for (int i = 8; i <= 13; i++) {
				System.out.println(valores[i]);
			}

			System.out.println(rs);
			System.out.println("============ Números Pares ==============");
			for (int i = 0; i < valores.length; i++) {
				if (valores[i] % 2 == 0) {
					System.out.print(valores[i] + " | ");
				}
			}
			System.out.println(rs);
			System.out.println("============ Números impares ==============");
			for (int i = 0; i < valores.length; i++) {
				if (valores[i] % 2 != 0) {
					System.out.print(valores[i] + " | ");
				}
			}
				System.out.println(rs);
				System.out.println("============ Multiplos de 3 ==============");
				for (int i = 0; i < valores.length; i++) {
					if (valores[i] % 3 == 0) {
						System.out.print(valores[i] + " | ");
				
			}
				}
					
					System.out.println(rs);
					System.out.println("============ Multiplos de 4 ==============");
					for (int i = 0; i < valores.length; i++) {
						if (valores[i] % 4 == 0) {
							System.out.print(valores[i] + " | ");

		}
					}
					System.out.println(rs);
					System.out.println("============ Multiplos de 5 ==============");
					for (int i = 0; i < valores.length; i++) {
						if (valores[i] % 5 == 0) {
							System.out.print(valores[i] + " | ");
	}
					}
						
						System.out.println("============ Array reverso ============");
						
						for(int i = valores.length -1 ; i >= 0 ; i--) {
							System.out.println(valores[i]);
						}
}
	}
}

