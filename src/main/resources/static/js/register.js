function register() {
    return `
    <header>
      <h1><span>Registrarse como Proveedor</span></h1>
    </header>
    <div class="content">
      <div class="register_form">
        <form id="formRegister">
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
              <label for="address">Dirección</label>
              <input class="register_input" type="text" id="address" name="address" placeholder="Dirección" required>
            </div>
            <div class="input_comp">
              <label for="confirmPassword">Confirmar Contraseña</label>
              <input type="password" id="confirmPassword" placeholder="Confirmar Contraseña" required>
            </div>
          </div>
          <input class="button_submit" type="submit" value="Registrarse" id="registrarBtn">
        </form>
        <input class="cancelButton" type="submit" value="cancelar" onclick="navigateTo('/index')">
      </div>
    </div>
  `;

    // Aquí es donde agregamos el evento click al botón de registro
    const registrarBtn = document.getElementById('registrarBtn');
    registrarBtn.addEventListener('click', this.registrar);

    // Función que se ejecutará cuando se haga clic en el botón de registro

}

const registrarUsuario = (e) => {
    e.preventDefault(); // Evitar el comportamiento predeterminado del formulario

    // Obtener los valores de los campos de entrada
    const nombre = document.getElementById('name').value;
    const apellidos = document.getElementById('lastName').value;
    const telefono = document.getElementById('phone').value;
    const email = document.getElementById('email').value;
    const cedula = document.getElementById('id').value;
    const contrasena = document.getElementById('password').value;
    const direccion = document.getElementById('address').value;
    const confirmarContrasena = document.getElementById('confirmPassword').value;

    const register = {
        name: nombre,
        lastName: apellidos,
        mobile: telefono,
        email: email,
        id: cedula,
        password: contrasena,
        address: direccion,
    }

    // Aquí puedes realizar la lógica necesaria para registrar al usuario
    // Por ejemplo, puedes enviar una solicitud al servidor utilizando fetch() o XMLHttpRequest
    // o realizar alguna otra operación necesaria

    doRegister(register).then((data) => {
        console.log(data); // JSON data parsed by `data.json()` call
    });
}

async function doRegister(registerForm = {}) {
    const url = 'http://localhost:8080/registrarse';

    const response = await fetch(url, {
        method: "POST",
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(registerForm),
    });
    return response.json(); // parses JSON response into native JavaScript objects
}
/*Primero, se agrega un id="registrarBtn" al botón de registro dentro del formulario <input class="button_submit" type="submit" value="Registrarse" id="registrarBtn">.


Después de retornar la cadena de texto que representa el HTML, se obtiene una referencia al botón de registro utilizando const registrarBtn = document.getElementById('registrarBtn').


Luego, se agrega el evento click al botón de registro utilizando registrarBtn.addEventListener('click', registrarUsuario). Esto significa que cuando se haga clic en el botón, se ejecutará la función registrarUsuario.


Se define la función registrarUsuario(event) que se ejecutará cuando se haga clic en el botón de registro. Esta función recibe el objeto event como parámetro, que contiene información sobre el evento click.


Dentro de la función registrarUsuario, se utiliza event.preventDefault() para evitar el comportamiento predeterminado del formulario, que es enviar los datos y recargar la página.


Luego, se obtienen los valores de los campos de entrada utilizando document.getElementById('id').value, donde 'id' es el id del campo de entrada correspondiente.


Después, se puede realizar la lógica necesaria para registrar al usuario, como enviar una solicitud al servidor utilizando fetch()*/


registrar = async () => {
    event.preventDefault();
    var nombre = document.getElementById('name').value;
    var apellidos = document.getElementById('lastName').value;
    var telefono = document.getElementById('phone').value;
    var email = document.getElementById('email').value;
    var cedula = document.getElementById('id').value;
    var contrasena = document.getElementById('password').value;
    var direccion = document.getElementById('address').value;
    var confirmarContrasena = document.getElementById('confirmPassword').value;

    const register = {
        name: nombre,
        lastName: apellidos,
        mobile: telefono,
        email: email,
        id: cedula,
        password: contrasena,
        address: direccion,
    }
    if(contrasena===confirmarContrasena){
        const request = new Request(`${"http://localhost:8080/registrarse"}?nombre= ${nombre.value} &apellidos=${apellidos.value}
                                    &telefono=${telefono.value}&email=${email.value}&cedula=${cedula.value}&contrasena=${contrasena.value}&direccion=${direccion.value}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(register)
        });
        let response = await fetch(request);
        if (!response.ok) {
            alert("Probelmas para arrgelar");
            throw new Error("Error de verificacion");
        }
    }
    // location.reload();
}