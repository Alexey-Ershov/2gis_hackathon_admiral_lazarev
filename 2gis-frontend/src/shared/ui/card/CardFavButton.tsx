// src/shared/ui/card/CardFavButton.tsx
import { ButtonHTMLAttributes } from "react"

type Props = ButtonHTMLAttributes<HTMLButtonElement>

export function CardFavButton({className = "", ...rest}: Props) {
	return (
		<button
			aria-label="В избранное"
			className={
				"pointer-events-auto absolute right-2 top-2 md:right-3 md:top-3 " +
				"grid size-8 place-items-center rounded-full bg-white/85 backdrop-blur " +
				"ring-1 ring-inset ring-black/10 " +
				className
			}
			{ ...rest }
		>
			{/* Иконка-сердце (stroke) */ }
			<svg viewBox="0 0 24 24" className="size-5 fill-none stroke-black/70">
				<path d="M12 21s-7.5-4.35-9.33-8.4A5.67 5.67 0 0 1 12 5.67 5.67 5.67 0 0 1 21.33 12.6C19.5 16.65 12 21 12 21Z"
				      strokeWidth="1.5"/>
			</svg>
		</button>
	)
}