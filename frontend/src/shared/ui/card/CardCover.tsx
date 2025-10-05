// src/shared/ui/card/CardCover.tsx
import { PropsWithChildren } from "react"

type Props = PropsWithChildren<{
	src: string
	alt?: string
	className?: string
	height?: number // px
}>

export function CardCover({ src, alt = "", className = "", children }: Props) {
	return (
		<div className={"relative " + className}>
			<img
				src={src}
				alt={alt}
				className="w-full rounded-[11.17px] object-cover h-[138px]"
			/>
			<div className="pointer-events-none absolute inset-0">{children}</div>
		</div>
	)
}