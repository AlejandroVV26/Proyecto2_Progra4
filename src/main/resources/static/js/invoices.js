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
                <input type="text" id="clientId" placeholder="ID del Cliente" required>
              </div>
              <div class="input_comp">
                <label for="total">Total</label>
                <input type="number" id="total" placeholder="Total de la factura" required>
              </div>
            </div>
            <div class="input_par">
              <div class="input_comp">
                <label for="date">Fecha</label>
                <input type="date" id="date" required>
              </div>
            </div>
            <input class="button_submit" type="submit" value="Facturar">
          </form>
        </section>
    `;
}