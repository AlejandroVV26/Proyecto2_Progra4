function profile() {
    let user ="";

    try{
         user = getUser();
    } catch (e) {
        user ="anonymous";
    }
    return `
    <header>
      <h1>Perfil de Usuario</h1>
    </header>
    <div>
      ${renderMenu(user)}
    </div>
    <section class="content">
      <h1>Información del Perfil</h1>
      <div>
        <form>
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
              <label for="email">Correo Electrónico</label>
              <input type="email" id="email" placeholder="Correo Electrónico" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="password">Contraseña</label>
              <input type="password" id="password" placeholder="Contraseña" required>
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
          <input class="button_submit" type="submit" value="Guardar Cambios">
        </form>
      </div>
    </section>
  `;
}