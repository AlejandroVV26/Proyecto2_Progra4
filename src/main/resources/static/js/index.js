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
                     <input class="button_submit" type="submit" value="Log In" onclick="">
                    <input class="registerButton" type="submit" value="Registrarse" onclick="">
                   
                </form>
            </div>
        </section>
    `;
}

