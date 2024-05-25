function clients() {
    return `<header>
    <h1>Clientes</h1>
  </header>
  <div>${renderMenu('proveedor')}</div>
  <section class="content">
    <form onsubmit="registrarCliente(event)">
      <div class="input_par">
        <div class="input_comp">
          <label for="name">Nombre</label>
          <input type="text" id="name" placeholder="Nombre" required>
        </div>
        <div class="input_comp">
          <label for="lastName">Apellidos</label>
          <input type="text" id="lastName" placeholder="Apellidos" required>
        </div>
      </div>
      <div class="input_par">
        <div class="input_comp">
          <label for="phone">Teléfono</label>
          <input type="text" id="phone" placeholder="Teléfono" required>
        </div>
        <div class="input_comp">
          <label for="email">Correo Electrónico</label>
          <input type="text" id="email" placeholder="Correo Electrónico" required>
        </div>
      </div>
      <div class="input_par">
        <div class="input_comp">
          <label for="id">Cédula</label>
          <input type="text" id="id" placeholder="Cédula" required>
        </div>
        <div class="input_comp">
          <label for="address">Dirección</label>
          <input type="text" id="address" placeholder="Dirección" required>
        </div>
      </div>
      <div class="form-row">
        <div class="input-group">
          <label for="selectOption">Seleccionar tipo de cliente:</label>
          <select id="selectOption">
            <option value="Cliente Fisico" style="font-size: 20px;">Cliente Físico</option>
            <option value="Cliente Juridico" style="font-size: 20px;">Cliente Jurídico</option>
          </select>
        </div>
      </div>
      <input class="button_submit" type="submit" value="Registrar">
    </form>
  </section>`;
}

function registrarCliente(event) {
    event.preventDefault(); // Evitar el envío del formulario

    const name = document.getElementById('name').value;
    const lastName = document.getElementById('lastName').value;
    const phone = document.getElementById('phone').value;
    const email = document.getElementById('email').value;
    const id = document.getElementById('id').value;
    const address = document.getElementById('address').value;
    const type = document.getElementById('selectOption').value;

    const client = {
        id:id,
        name:name,
        lastName:lastName,
        phone:phone,
        email:email,
        address:address,
        type:type,
    };



    fetch(`/api/clientes/agregar/${proveedorId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(client)
    })
        .then(response => {
            if (response.ok) {
                // Manejo de respuesta exitosa
                console.log('Cliente registrado correctamente');
            } else {
                // Manejo de error
                throw new Error('Error al registrar el cliente');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}