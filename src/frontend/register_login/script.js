document.getElementById('show-login').addEventListener('click', (e) => {
    e.preventDefault();
    document.getElementById('login-form').classList.add('active');
    document.getElementById('register-form').classList.remove('active');
    document.getElementById('login-toggle').classList.add('active');
    document.getElementById('register-toggle').classList.remove('active');
});

document.getElementById('show-register').addEventListener('click', (e) => {
    e.preventDefault();
    document.getElementById('register-form').classList.add('active');
    document.getElementById('login-form').classList.remove('active');
    document.getElementById('register-toggle').classList.add('active');
    document.getElementById('login-toggle').classList.remove('active');
});