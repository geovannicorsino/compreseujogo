package compreseujogo.teste;

import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;

public class VendedorTeste {

	public static void main(String[] args) {
		VendedorBo bo = new VendedorBo();
		Vendedor vendedor = new Vendedor(0, "Jennifer", "Luciana Isabela Duarte",
				"jjenniferlucianaisabeladuarte@vnews.com.br", "1234", null, "Praça General Osório 45",
				"(41) 99108-8676", "80020-930", "296.416.029-50", true, "Curitiba", "Centro", Sexo.Masculino,
				null, null, Estado.PR);

		try {
			
		} catch (Exception e) {

		}
	}
}
