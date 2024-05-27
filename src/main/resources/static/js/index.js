function index() {
    return `
    <header>
      <h1>Facturar UNA</h1>
    </header>
    <section class="content">
      <div class="wrap">
        <form>
          <div class="input_comp">
            <label for="email">Correo Electrónico</label>
            <input type="text" id="email" placeholder="Correo Electrónico" required>
          </div>
          <div class="input_comp">
            <label for="password">Contraseña</label>
            <input type="password" id="password" placeholder="Contraseña" required>
          </div>
          <input class="button_submit" type="button" value="Iniciar sesión" onclick="logIn()">
          <input class="registerButton" type="button" value="Registrarse" onclick="navigateTo('/register')">
        </form>
      </div>
    </section>`
}

function logIn() {
    const id = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const url = '{http://localhost:8080/login}?id=${id}&password=${password}';
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => {
        if (!response.ok) {
            throw new Error("Error al ingresar");
        }
        console.log("Ingreso Exitoso");
    }).catch((error) => {
        console.error("Error: ", error);
    });
    event.preventDefault();
    navigateTo('/home');
}