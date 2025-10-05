// src/shared/ui/RatingBadge.tsx
import { HTMLAttributes } from "react"
import { StarSolidIcon } from "@shared/assets/icons"

type Props = {
	value: number | string
	/** Показывать ли иконку звезды слева */
	withIcon?: boolean
} & HTMLAttributes<HTMLDivElement>

export function RatingBadge({ value, withIcon = true, className = "", ...rest }: Props) {
	return (
		<div
			aria-label={`Оценка ${value}`}
			className={
				"flex flex-row items-center gap-[1px] rounded-[6px] bg-white text-black " +
				// компактные отступы
				"py-[2px] px-[4px] " +
				// типографика из макета: Montserrat Medium 11 / 122.3%
				"text-[11px] leading-[1.223] font-medium font-[var(--secondary-font)] w-fit" +
				className
			}
			{...rest}
		>
			{withIcon && <StarSolidIcon className="fill-[var(--color-accent)]" />}
			<span className={"h-[13px] flex text-center text"}><p className={"h-fit mt-[-1px]"}>{value}</p></span>
		</div>
	)
}