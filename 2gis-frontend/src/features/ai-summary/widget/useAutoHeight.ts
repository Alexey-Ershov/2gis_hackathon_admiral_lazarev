import { useEffect } from "react";

/** Авто-подстройка высоты для iFrame (работает и кросс-домен) */
export function useAutoHeight() {
	useEffect(() => {
		const post = () => {
			const h = Math.max(
				document.body.scrollHeight,
				document.documentElement.scrollHeight
			);
			// укажи origin родителя вместо "*", если знаешь домен
			window.parent?.postMessage({ __iframeHeight: h }, "*");
		};
		// 1) базовые триггеры
		window.addEventListener("load", post);
		window.addEventListener("resize", post);

		// 2) следим за мутациями, чтобы ловить ленивые блоки/картинки
		const mo = new MutationObserver(post);
		mo.observe(document.documentElement, {
			childList: true,
			subtree: true,
			attributes: true,
			characterData: true,
		});

		// 3) страховка таймером
		const id = window.setInterval(post, 800);

		return () => {
			window.removeEventListener("load", post);
			window.removeEventListener("resize", post);
			mo.disconnect();
			clearInterval(id);
		};
	}, []);
}