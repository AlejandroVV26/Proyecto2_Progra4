function invoices() {
    return `
        <header>
            <h1>Facturar</h1>
        </header>
        <div>
            ${renderMenu('proveedor')}
        </div>
        <section class="content">
            <form>
            <div class="input_par">
              <div class="input_comp">
                <label for="clientId">ID del Cliente</label>
                <select id="clientId" class = "form-select">
                </select>
              </div>
            </div>
            <div class="input_comp">
                <label for="productos">Productos</label>
                <select id="producto" class = "form-select">
                </select>
              </div>
            <div class="input_par">
              <div class="input_comp">
                <label for="date">Fecha</label>
                <input type="date" id="date" required>
              </div>
            </div>
            <input class="button_submit" type="submit" value="Facturar" onclick="navigateTo('/Confirmacion')">
          </form>
        </section>
    `;
}
