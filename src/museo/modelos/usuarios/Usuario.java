package museo.modelos.usuarios;

import museo.interfaces.IAutenticable;

public abstract class Usuario implements IAutenticable {
    protected String username;
    protected String clave;

    public Usuario(String username, String clave) {
        this.username = username;
        this.clave = clave;
    }

    @Override
    public boolean autenticar(String usuario, String clave) {
        return this.username.equals(usuario) && this.clave.equals(clave);
    }

    public String getUsername() { return username; }
}
