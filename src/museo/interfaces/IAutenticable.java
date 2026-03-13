package museo.interfaces;

/**
 * Interfaz para entidades que pueden autenticarse en el sistema.
 */
public interface IAutenticable {
    /**
     * Autentica a un usuario.
     * 
     * @param usuario El nombre de usuario.
     * @param clave La contraseña.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    boolean autenticar(String usuario, String clave);
}
