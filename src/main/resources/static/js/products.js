function products() {
    return `
        <header>
            <h1>Productos</h1>
        </header>
        <div>
            ${renderMenu('proveedor')}
        </div>
        <section class="content">
            <div class="wrap">
                <form>
                    <label for="busc">Buscar producto por id:</label><br>
                    <input type="text" id="busc" required>
                    <input id="buscar" class="button_submit" type="submit" value="Buscar">
                </form>
                <form>
                    <!-- Agrega los campos de formulario para registrar/editar un producto aquí -->
                    <input class="button_submit" type="submit" value="Registrar">
                </form>
            </div>
        </section>
    `;
}