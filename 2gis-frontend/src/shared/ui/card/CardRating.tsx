// src/shared/ui/card/CardRating.tsx
import { RatingBadge } from "@/shared/ui/RatingBadge"

export function CardRating({ value, className = "" }: { value: number; className?: string }) {
	return (
		<div className={"pointer-events-auto absolute left-2 top-2 md:left-3 md:top-3 " + className}>
			<RatingBadge value={value} />
		</div>
	)
}