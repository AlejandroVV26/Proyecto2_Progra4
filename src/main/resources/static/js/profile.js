function profile() {
    const user = getUser();
    return `
        <header>
            <h1>Perfil de Usuario</h1>
        </header>
        <div>
            ${renderMenu(user)}
        </div>
        <section class="content">
            <h1>Información del Perfil</h1>
            <div>
                <form>
                    <!-- Agrega los campos de formulario para editar el perfil aquí -->
                    <input class="button_submit" type="submit" value="Guardar Cambios">
                </form>
            </div>
        </section>
    `;
}