// Función para obtener el perfil del usuario y renderizar el formulario
function profile() {
    let user = "";
    try {
        user = getUser();
    } catch (e) {
        user = "anonymous";
    }

    document.body.innerHTML = `
        <header>
            <h1>Perfil de Usuario</h1>
        </header>
        <div>${renderMenu(user)}</div>
        <section class="content">
            <h1>Información del Perfil</h1>
            <div>
                <form id="proveedorForm">
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
                            <label for="telefono">Teléfono</label>
                            <input type="text" id="telefono" placeholder="Teléfono" required>
                        </div>
                        <div class="input_comp">
                            <label for="email">Correo Electrónico</label>
                            <input type="email" id="email" placeholder="Correo Electrónico" required>
                        </div>
                    </div>
                    <div class="input_par">
                        <div class="input_comp">
                            <label for="cedula">Cédula</label>
                            <input type="text" id="cedula" placeholder="Cédula" required>
                        </div>
                        <div class="input_comp">
                            <label for="password">Contraseña</label>
                            <input type="password" id="password" placeholder="Contraseña" required>
                        </div>
                    </div>
                    <div class="input_par">
                        <div class="input_comp">
                            <label for="address">Dirección</label>
                            <input type="text" id="address" placeholder="Dirección" required>
                        </div>
                        <div class="input_comp">
                            <label for="confirmPassword">Confirmar Contraseña</label>
                            <input type="password" id="confirmPassword" placeholder="Confirmar Contraseña" required>
                        </div>
                    </div>
                    <input class="button_submit" type="submit" value="Guardar Cambios">
                </form>
            </div>
        </section>
    `;

    document.getElementById('proveedorForm').addEventListener('submit', editarProveedor);
}

// Función para editar los datos del proveedor
async function editarProveedor(event) {
    event.preventDefault();

    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        alert('Las contraseñas no coinciden.');
        return;
    }

    const formData = {
        id: document.getElementById('cedula').value,
        nombre: document.getElementById('name').value,
        apellido: document.getElementById('lastName').value,
        telefono: document.getElementById('telefono').value,
        correo: document.getElementById('email').value,
        direccion: document.getElementById('address').value,
        contraseña: password
    };

    try {
        const response = await fetch('/api/proveedores/editar', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            alert('Datos actualizados correctamente.');
        } else {
            alert('Ocurrió un error al actualizar los datos. Por favor, inténtalo de nuevo más tarde.');
        }
    } catch (error) {
        console.error('Error al actualizar los datos del proveedor:', error);
        alert('Ocurrió un error al actualizar los datos. Por favor, inténtalo de nuevo más tarde.');
    }
}

// Llamar a la función profile para renderizar la página
document.addEventListener('DOMContentLoaded', profile);
