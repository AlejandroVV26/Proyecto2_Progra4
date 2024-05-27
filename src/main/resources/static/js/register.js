function register() {
    return `<header>
    <h1><span>Registrarse como Proveedor</span></h1>
  </header>
  <div class="content">
    <div class="register_form">
      <form id="formRegister" onsubmit="registerProveedor(event)">
        <div class="input_par">
          <div class="input_comp">
            <label for="name">Nombre</label>
            <input class="register_input" type="text" id="name" name="name" placeholder="Nombre" required>
          </div>
          <div class="input_comp">
            <label for="lastName">Apellidos</label>
            <input class="register_input" type="text" id="lastName" name="lastName" placeholder="Apellidos" required>
          </div>
        </div>
        <div class="input_par">
          <div class="input_comp">
            <label for="phone">Teléfono</label>
            <input class="register_input" type="text" id="phone" name="phone" placeholder="Teléfono" required>
          </div>
          <div class="input_comp">
            <label for="email">Correo Electrónico</label>
            <input class="register_input" type="text" id="email" name="email" placeholder="Correo Electrónico" required>
          </div>
        </div>
        <div class="input_par">
          <div class="input_comp">
            <label for="id">Cédula</label>
            <input class="register_input" type="text" id="id" name="id" placeholder="Cédula" required>
          </div>
          <div class="input_comp">
            <label for="password">Contraseña</label>
            <input class="register_input" type="password" id="password" name="password" placeholder="Contraseña" required>
          </div>
        </div>
        <div class="input_par">
          <div class="input_comp">
            <label for="confirmPassword">Confirmar Contraseña</label>
            <input type="password" id="confirmPassword" placeholder="Confirmar Contraseña" required>
          </div>
        </div>
        <input class="button_submit" type="submit" value="Registrarse" id="registrarBtn">
      </form>
      <input class="cancelButton" type="submit" value="cancelar" onclick="navigateTo('/index')">
    </div>
  </div>`;
}

async function registerProveedor(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const proveedorData = Object.fromEntries(formData);

    try {
        // Crear un objeto Proveedor con los datos del formulario
        const proveedor = {
            id: proveedorData.id,
            nombre: proveedorData.name,
            apellidos: proveedorData.lastName,
            telefono: proveedorData.phone,
            correo: proveedorData.email,
            contrasena: document.getElementById("password").value
        };

        // Registrar el proveedor
        const response = await fetch('http://localhost:8080/registrarse/{{nombre}}/{{apellidos}}/{{telefono}}/{{correo}}/{{id}}/{{contrasena}}', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(proveedor)
        });

        if (response.ok) {
            alert('Proveedor registrado exitosamente.');
            navigateTo('/index');
        } else {
            alert('Ocurrió un error al registrar el proveedor. Por favor, inténtalo de nuevo más tarde.');
        }
    } catch (error) {
        console.error('Error al registrar proveedor:', error);
        alert('Ocurrió un error al registrar el proveedor. Por favor, inténtalo de nuevo más tarde.');
    }
}

function navigateTo(route) {
    // Lógica para navegar a la ruta especificada
    console.log('Navegando a:', route);
}