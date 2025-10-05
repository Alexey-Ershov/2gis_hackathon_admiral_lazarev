/ ** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./index.html', './src/**/*.{ts,tsx}'],
    plugins: {
        '@tailwindcss/postcss': {},
    },
    theme: {
        extend: {
            fontFamily: {
                main: ['var(--main-font)', 'sans-serif'],
                secondary: ['var(--secondary-font)', 'sans-serif'],
                primary: ['var(--primary-font)', 'sans-serif'],
            },
            colors: {
                accent: "var(--color-accent)",
            },
        }
    },
};