function accesos() {
    return `
        <header>
            <h1>Accesos</h1>
        </header>
        <div>
            ${renderMenu('admin')}
        </div>
        <section class="content">
            <div class="container">
                <h2>Solicitudes de Acceso</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Juan</td>
                            <td>Pérez</td>
                            <td><a href="#"><img class="access_img" src="/images/accesos.svg" alt="Aceptar"></a></td>
                        </tr>
                        <!-- Agrega más filas de solicitudes de acceso aquí -->
                    </tbody>
                </table>
            </div>
        </section>
    `;
}