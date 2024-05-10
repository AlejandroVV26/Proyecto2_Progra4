function home() {
    const content = `
    <div class="forAdmin">
      <!-- Contenido para administrador -->
    </div>
    <div class="forProvs">
      <!-- Contenido para proveedor -->
    </div>
  `;

    return `
    <header>
      <h1>Bienvenido</h1>
    </header>
    <div>
      ${renderMenu('proveedor')}<!--admin o proveedor-->
    </div>
    <section class="content">
      ${content}
    </section>
  `;
}