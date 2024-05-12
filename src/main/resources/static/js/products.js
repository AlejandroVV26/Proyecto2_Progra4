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
          <div class="buscar-container">
            <div class="input_comp">
              <label for="busc">Buscar producto por id:</label>
              <input type="text" id="busc" placeholder="ID del producto" required>
            </div>
            <input id="buscar" class="btn-buscar" type="submit" value="Buscar">
          </div>
        </form>
        <form>
          <div class="input_par">
            <div class="input_comp">
              <label for="name">Descripción</label>
              <input type="text" id="name" placeholder="Descripción del producto" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="cost">Costo</label>
              <input type="number" id="cost" placeholder="Costo del producto" required>
            </div>
          </div>
          <input class="button_submit" type="submit" value="Registrar">
        </form>
      </div>
    </section>
  `;
}