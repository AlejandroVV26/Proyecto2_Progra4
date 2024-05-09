const routes = {
    '/': index, // Reemplaza 'inde' por 'index'
    '/register':register,
    '/home': home,
    '/profile': profile,
    '/accesos': accesos,
    '/clients': clients,
    '/products': products,
    '/invoices': invoices
};
function router() {
    const path = window.location.pathname;
    const route = routes[path] || routes['/'];
    const appDiv = document.getElementById('app');
    appDiv.innerHTML = route();
}

window.addEventListener('popstate', router);

function navigateTo(path) {
    window.history.pushState({}, path, path);
    router();
}

document.addEventListener('DOMContentLoaded', function() {
    document.body.addEventListener('click', function(e) {
        if (e.target.matches('a')) {
            e.preventDefault();
            navigateTo(e.target.getAttribute('href'));
        }
    });
    router();
});