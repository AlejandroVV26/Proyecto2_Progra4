function products() {
    return `
    <header>
      <h1>Productos</h1>
    </header>
    <div>${renderMenu('proveedor')}</div>
    <section class="content">
      <div class="wrap">
        <form onsubmit="registrarProducto(event)">
          <div class="input_par">
            <div class="input_comp">
              <label for="id">ID</label>
              <input type="text" id="id" placeholder="ID del producto" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="categoria">Categoría</label>
              <input type="text" id="categoria" placeholder="Categoría del producto" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="descripcion">Descripción</label>
              <input type="text" id="descripcion" placeholder="Descripción del producto" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="unidad_medida">Unidad de Medida</label>
              <input type="text" id="unidad_medida" placeholder="Unidad de Medida del producto" required>
            </div>
          </div>
          <div class="input_par">
            <div class="input_comp">
              <label for="costo">Costo</label>
              <input type="number" id="costo" placeholder="Costo del producto" required>
            </div>
          </div>
          <input class="button_submit" type="submit" value="Registrar" >
        </form>
      </div>
    </section>
  `;
}

// Función para registrar un nuevo producto
function registrarProducto(event) {
    event.preventDefault();

    const id = document.getElementById('id').value;
    const categoria = document.getElementById('categoria').value;
    const description = document.getElementById('descripcion').value;
    const unidadMedida = document.getElementById('unidad_medida').value;
    const costo = document.getElementById('costo').value;

    const nuevoProducto = {
        id: id,
        categoria:categoria,
        description:description,
        unidadMedida:unidadMedida,
        costo:costo,
    };

    fetch('api/productos/agregar/${proveedorId}', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoProducto)
    })
        .then(response => {
            if (response.ok) {
                alert('Producto registrado exitosamente');
            } else {
                alert('Error al registrar el producto');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error al registrar el producto');
        });
}
