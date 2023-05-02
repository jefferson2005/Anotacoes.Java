package br.cpm.estruturas.atividades;

import java.io.FileWriter;

/**
 * <b>GerarArquivo</b><br< A classe GerarArquivo cria novos arquivos ou os abre.
 * Insere dados no arquivo<br>
 * e possui um método chamado gravar.<br>
 * O método gravar pede 2 argumentos, onde<br>
 * <ol>
 * <li>nome_arquivo: você deve passar o caminho com o nome do arquivo</li>
 * <li>conteudo: você deve passar o que está escrito no arquivo</li>
 * </ol>
 *
 * @author jefferson.loliveira9
 * @email jeff@gmail.com
 */

public abstract class OS {

	/**
	 * <b>gravar</b> O método gravar realiza a gravação ou a abertura do arquivo
	 * passado como parametro e, adiciona o conteúdo ao arquivo.
	 * 
	 * @param nome_arquivo: nome e/ou caminho do arquivo com extsão
	 * @param conteudo:     texto que será inserido no arquivo.
	 * @return
	 */

	public static String gravar(String nome_arquivo, String conteudo) {
		String msg = "";
		// Para criar um arquivo, iremos usar a classe Filewritter
		FileWriter arquivo = null;

		try {
			arquivo = new FileWriter(nome_arquivo);
			arquivo.write(conteudo);
			msg = "O arquivo " + nome_arquivo + " foi criado e escrito";
		} catch (Exception e) {
			System.out.println("Erro ao tratar o arquivo -> " + e.getMessage());
			msg = "Erro ao tratar o arquivo -> " + e.getMessage();
		} finally {
			try {
				arquivo.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		return msg;
	}

}
