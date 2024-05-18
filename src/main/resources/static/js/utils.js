function renderMenu(user) {
    let menu = `<div class="tabs">
    <a href="#" onclick="navigateTo('/home'); return false;" class="tab">
      <img src="/images/casa.svg" alt="">
      <label>Home</label>
    </a>
    <a href="#" onclick="navigateTo('/profile'); return false;" class="tab">
      <img src="/images/perfil.svg" alt="">
      <label>Perfil</label>
    </a>`;

    if (user === 'admin') {
        menu += `<a href="#" onclick="navigateTo('/accesos'); return false;" class="tab">
      <img src="/images/accesos.svg" alt="">
      <label>Accesos</label>
    </a>`;
    } else if (user === 'proveedor') {
        menu += `<a href="#" onclick="navigateTo('/clients'); return false;" class="tab">
      <img src="/images/accesos.svg" alt="">
      <label>Clientes</label>
    </a>
    <a href="#" onclick="navigateTo('/products'); return false;" class="tab">
      <img src="/images/productos.svg" alt="">
      <label>Productos</label>
    </a>
    <a href="#" onclick="navigateTo('/invoices'); return false;" class="tab">
      <img src="/images/declarar.svg" alt="">
      <label>Facturar</label>
    </a>`;
    }

    menu += `<a href="#" onclick="navigateTo('/'); return false;" class="tab">
    <img src="/images/door-closed.svg" alt="">
    <label>Logout</label>
  </a>
</div>`;

    return menu;
}

function getUser() {

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    if (email === 'admin@admin.com' && password === 'admin') {
        return 'admin';
    } else if (email === 'proveedor@proveedor.com' && password === 'proveedor') {
        return 'proveedor';
    }
    return null;
}