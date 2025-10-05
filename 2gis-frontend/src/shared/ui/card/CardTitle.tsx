// src/shared/ui/card/CardTitle.tsx
export function CardTitle({ children, className = "" }: { children: string; className?: string }) {
	return (
		<h3
			className={
				"mt-3 line-clamp-2 break-words  primary-font " +
				"mb-[3px] font-medium text-[18px] " + className
			}
			title={children}
		>
			{children}
		</h3>
	)
}