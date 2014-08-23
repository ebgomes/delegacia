package controllers.login;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import lombok.Getter;
import lombok.Setter;

import org.primefaces.context.RequestContext;

import br.com.pa.arquitetura.ConfirmaQue;
import br.com.pa.arquitetura.ControladorBasicoDeFormulario;
import br.com.pa.arquitetura.EntityState;
import br.com.pa.model.Login;
import br.com.pa.remote.LoginRemote;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class LoginController extends
		ControladorBasicoDeFormulario<Login, LoginRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	private LoginRemote loginRemote;

	public Login login = new Login();

	public Login loginNovo = new Login();

	public String senhaParaConfirmar;

	public String autenticar() {
		Login loginSalvo = loginRemote.buscaPorUsuario(login.getUsuario());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if (ConfirmaQue.naoEhNulo(loginSalvo)) {
			if (loginSalvo.getSenha().equals(login.getSenha())) {
				session.setAttribute("login", loginSalvo);
				session.setAttribute("usuario", loginSalvo.getNomeDoUsuario());
				return "index.xhtml";
			} else {
				mostraMsgGenerica("Usu�rio e/ou senha inv�lidos!",
						FacesMessage.SEVERITY_WARN);
				return "login.xhtml";
			}
		} else {
			return "login.xhtml";
		}

	}

	@Override
	protected Login criaNovoObjeto() {
		return new Login();
	}

	public void inicio() {
		this.login = new Login();
	}

	@Override
	protected LoginRemote servidor() {
		return loginRemote;
	}

	public void criarNovo() {
		System.out.println("criar novo");
		loginNovo = null;
		loginNovo = new Login();
		loginNovo.setEntityState(EntityState.NEW);
		senhaParaConfirmar = "";
	}

	public void criar() {
		System.out.println("criar");
		if (loginNovo.getSenha().equalsIgnoreCase(senhaParaConfirmar)) {

			if (ConfirmaQue.naoEhNulo(loginRemote.buscaPorUsuario(loginNovo
					.getUsuario()))) {
				mostraMsgGenerica("Este usuario j� est� cadastrado!",
						FacesMessage.SEVERITY_WARN);

			} else {
				try {
					loginNovo.setEntityState(EntityState.NEW);
					loginRemote.confirm(loginNovo);
					criarNovo();
				} catch (Exception e) {
					e.printStackTrace();
				}

				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("dialogNovo.hide()");
			}
		} else {
			mostraMsgGenerica("As senhas devem ser iguais !",
					FacesMessage.SEVERITY_WARN);
		}
	}
}