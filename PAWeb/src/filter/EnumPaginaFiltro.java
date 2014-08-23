package filter;

public enum EnumPaginaFiltro {

	LOGIN_PAGE("login.xhtml"),
	LOGIN_PAGE1("/login/login.xhtml"),
    ERROR_PAGE("error.xhtml"),
    INDEX_PAGE("index.xhtml"),
    ACESSO_PAGE("acesso.xhtml"),
    LOGOUT_PAGE("logout");
	
    private String url;

    EnumPaginaFiltro(String url)
    {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }	
    
}
