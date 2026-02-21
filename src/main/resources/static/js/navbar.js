const bars = document.querySelector('.bars');
const sidebar = document.querySelector('.sidebar');
const overlay = document.querySelector('.overlay');

bars.addEventListener('click', () => {
    sidebar.classList.toggle('active');
    overlay.classList.toggle('active');
});

overlay.addEventListener('click', () => {
    sidebar.classList.remove('active');
    overlay.classList.remove('active');
});