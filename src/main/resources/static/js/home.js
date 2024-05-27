function home() {
    const user = getUser();
    let content = '';

    if (user === 'admin') {
        content = `
      <div class="forAdmin">
        <h3 style="text-align:center">Usuarios Registrados</h3>
    <table>
    <tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Apellidos</th>
    </tr>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    </table>
      </div>
    `;
    } else if (user === 'proveedor') {
        content = `
      <div class="forProvs">
        <div class="bottom_separator">
          <h2>Facturas</h2>
          <table>
  <tr>
    <th>ID</th>
    <th>Cliente ID</th>
    <th>Total</th>
    <th>Fecha</th>
    <th>PDF</th>
    <th>XML</th>
  </tr>
  <tr>
    <td>1</td>
    <td>33334</td>
    <td>2800</td>
    <td>2024-04-12 18:00:00</td>
    <td><a href="/images/filetype-pdf.svg" target="_blank"><img src="/images/filetype-pdf.svg" alt="PDF" /></a></td>
    <td><a href="/images/filetype-xml.svg" target="_blank"><img src="/images/filetype-xml.svg" alt="XML" /></a></td>
  </tr>
</table>
        </div>
        <div class="bottom_separator">
          <h2>Clientes</h2>
          <table class="table">
  <tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Apellidos</th>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>
        </div>
        <div class="bottom_separator">
          <h2>Productos</h2>
          <table class="table">
 <tr>
   <th>ID</th>
   <th>Descripción</th>
   <th>Costo</th>
 </tr>
 <tr>
   <td></td>
   <td></td>
   <td></td>
 </tr>
 <tr>
   <td></td>
   <td></td>
   <td></td>
 </tr>
</table>
        </div>
      </div>
    `;
    }

    return `
    <header>
      <h1>Bienvenido ${user}</h1>
    </header>
    <div>
      ${renderMenu(user)}
    </div>
    <section class="content">
      ${content}
    </section>
  `;
}

function giveAccess(id) {
    const url = 'http://localhost:8080/giveAccess/{{id}}';
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => {
        if (!response.ok) {
            throw new Error("Error al dar acceso al proveedor");
        }
        console.log("Acceso del proveedor es True");
    }).catch((error) => {
        console.error("Error: ", error);
    });
    event.preventDefault();
}

function revokeAccess(id) {
    const url = 'http://localhost:8080/revokeAccess/{{id}}';
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => {
        if (!response.ok) {
            throw new Error("Error al dar acceso al proveedor");
        }
        console.log("Acceso del proveedor es False");
    }).catch((error) => {
        console.error("Error: ", error);
    });
    event.preventDefault();
}