function register() {
    return `
<html>
  <head>
    <title>Registrarse como Proveedor</title>
    <div>
      <h1><span>Registrarse como Proveedor</span></h1>
      <div>${renderMenu('proveedor')}</div>
    </div>
  </head>
  <body>
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
        </div>
        <input class="button_submit" type="submit" value="Registrarse">
      </form>
    </div>
  </body>
</html>`;
}