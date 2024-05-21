function clients() {
    return `
        <header>
  <h1>Clientes</h1>
</header>
<div>${renderMenu('proveedor')}</div>
<section class="content">
  <form>
    <div class="buscar-container">
      <div class="input_comp">
        <label for="busc">Buscar cliente por identificación:</label>
        <input type="text" id="busc" placeholder="Identificación" required>
      </div>
      <input id="buscar" class="btn-buscar" type="submit" value="Buscar">
    </div>
  </form>
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
</section>
    `;
}
