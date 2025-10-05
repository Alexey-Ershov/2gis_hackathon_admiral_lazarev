// src/shared/ui/card/CardTag.tsx
import { HTMLAttributes } from "react"
import { TagBadge } from "@/shared/ui/TagBadge"

type Props = { label: string } & HTMLAttributes<HTMLDivElement>

export function CardTag({ label, className = "", ...rest }: Props) {
	return (
		<div
			className={"pointer-events-auto absolute left-2 bottom-2 md:left-3 md:bottom-3 " + className}
			{...rest}
		>
			<TagBadge label={label} />
		</div>
	)
}