function home() {
    const user = getUser();
    let content = '';

    if (user === 'admin') {
        content = `
            <div class="forAdmin">
                <h2>Usuarios Registrados</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Juan</td>
                            <td>Pérez</td>
                        </tr>
                        <!-- Agrega más filas de usuarios aquí -->
                    </tbody>
                </table>
            </div>
        `;
    } else if (user === 'proveedor') {
        content = `
            <div class="forProvs">
                <div class="bottom_separator">
                    <h2>Facturas Declaradas</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Cliente ID</th>
                                <th scope="col">Total</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">PDF</th>
                                <th scope="col">XML</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>123</td>
                                <td>100.00</td>
                                <td>2023-05-01</td>
                                <td><a href="#"><img class="access_img" src="static/images/filetype-pdf.svg" alt="PDF"></a></td>
                                <td><a href="#"><img class="access_img" src="static/images/filetype-xml.svg" alt="XML"></a></td>
                            </tr>
                            <!-- Agrega más filas de facturas aquí -->
                        </tbody>
                    </table>
                </div>
                <div class="bottom_separator">
                    <h2>Clientes</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellidos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Ana</td>
                                <td>García</td>
                            </tr>
                            <!-- Agrega más filas de clientes aquí -->
                        </tbody>
                    </table>
                </div>
                <div class="bottom_separator">
                    <h2>Productos</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Costo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Producto A</td>
                                <td>10.00</td>
                            </tr>
                            <!-- Agrega más filas de productos aquí -->
                        </tbody>
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