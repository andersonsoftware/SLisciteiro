package util;

public class Constantes {
	public final static String URL,
								ERROLOGIN,
								ERROPERMISSAO,
								PUBLICDIR,
								FORNECEDORDIR,
								GERENTECOMPRASDIR,
								GERENTESETORDIR,
								SUPERVISORDIR,
								ERRONOTLOG,
								VPRESIDENTDIR,
								ASSETS,
								CSS,
								JS,
								IMG;
	public final static int QNTD_ITENS_PAGINA;
								
	static{
		///URL = "http://lsca.ddns.net";
		URL = "/SLisciteiro/";
		ERROLOGIN = URL + "login.jsp?erroLogInvalid=1";
		ERROPERMISSAO = URL+"view/public/home.jsp?erroPermission=1";
		PUBLICDIR = URL+"view/public/";
		FORNECEDORDIR = URL+"view/fornecedor/";
		GERENTECOMPRASDIR = URL+"view/gerenteCompras/";
		GERENTESETORDIR = URL+"view/gerenteSetor/";
		SUPERVISORDIR = URL+"view/supervisor/";
		ERRONOTLOG = URL + "login.jsp?erroNotLog=1";
		VPRESIDENTDIR = URL+"view/vpresident/";
		ASSETS = URL+"assets/";
		CSS = ASSETS+"css/";
		JS = ASSETS+"js/";
		IMG = ASSETS+"img/";
		QNTD_ITENS_PAGINA = 20;
	}
}
