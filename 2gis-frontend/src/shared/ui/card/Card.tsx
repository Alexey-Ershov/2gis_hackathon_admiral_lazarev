// src/shared/ui/card/Card.tsx
import { PropsWithChildren } from "react"

type CardProps = PropsWithChildren<{ className?: string }>

export function Card({ className = "", children }: CardProps) {
	return (
		<article className={"w-[162px] bg-white" + className}>
			{children}
		</article>
	)
}