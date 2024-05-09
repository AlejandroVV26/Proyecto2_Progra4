function clients() {
    return `
        <header>
            <h1>Clientes</h1>
        </header>
        <div>
            ${renderMenu('proveedor')}
        </div>
        <section class="content">
            <form>
                <label for="busc">Buscar cliente por identificación:</label><br>
                <input type="text" id="busc" required>
                <input id="buscar" class="button_submit" type="submit" value="Buscar">
            </form>
            <form>
                <!-- Agrega los campos de formulario para registrar/editar un cliente aquí -->
                <input class="button_submit" type="submit" value="Registrar">
            </form>
        </section>
    `;
}