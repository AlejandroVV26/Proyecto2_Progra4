function invoices() {
    return `
        <header>
            <h1>Facturar</h1>
        </header>
        <div>
            ${renderMenu('proveedor')}
        </div>
        <section class="content">
            <form onsubmit="Confirmacion()">
            <div class="input_par">
              <div class="input_comp">
                <label for="clientId">ID del Cliente</label>
                <select id="clientId" class = "form-select">
                </select>
              </div>
              <div class="input_comp">
                <br><label for="total">Total</label>
                <input type="number" id="total" placeholder="Total de la factura">
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
            <input class="button_submit" type="submit" value="Facturar">
          </form>
        </section>
    `;
}

function Confirmacion()  {
    return `
        <header>
            <h1>Facturar</h1>
        </header>
        <div>
            ${renderMenu('proveedor')}
        </div>
        <section class="content">
            <form onsubmit="registrarFactura(event)">
            <div class="input_par">
              <div class="input_comp">
                <label for="clientId">ID del Cliente</label>
                <select id="clientId" class = "form-select">
                </select>
              </div>
              <div class="input_comp">
                <br><label for="total">Total</label>
                <input type="number" id="total" placeholder="Total de la factura">
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
            <input class="button_submit" type="submit" value="Facturar">
          </form>
        </section>
    `;
}

function registrarFactura(event) {
    event.preventDefault(); // Evitar el envío del formulario
    const prov = document.getElementById('proveedor').value;
    const client = document.getElementById('ClienteId').value;
    const costo = document.getElementById('cost').value;

    const factura = {
        id:id,
        prov: prov,
        client: client,
        costoTotal:costo,
    };

    fetch(`/api/invoices/agregar`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(factura)
    })
        .then(response => {
            if (response.ok) {
                // Manejo de respuesta exitosa
                alert('Factura registrada correctamente');
            } else {
                // Manejo de error
                throw new alert('Error al registrar la factura');
            }
        })
        .catch(error => {
            alert('Error:', error);
        });
}