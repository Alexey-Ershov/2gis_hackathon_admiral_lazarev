// src/shared/theme/fonts.ts
import '@fontsource-variable/raleway';
import '@fontsource-variable/montserrat';

/**
 * Шрифтовые токены
 * Можно менять централизованно, например, на корпоративные в будущем
 */
export const fonts = {
	main: "'Raleway Variable', Raleway, sans-serif",
	secondary: "'Montserrat Variable', Montserrat, sans-serif",
};

/**
 * Применяет CSS-переменные для шрифтов
 */
export function applyFontVars() {
	const root = document.documentElement;
	root.style.setProperty('--main-font', fonts.main);
	root.style.setProperty('--secondary-font', fonts.secondary);
}