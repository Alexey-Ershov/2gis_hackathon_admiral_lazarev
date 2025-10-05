// src/shared/ui/card/CardMetaRow.tsx
type Props = {
	left: string
	right: string
	className?: string
	separator?: "dot" | "gap"
}

export function CardMetaRow({ left, right, separator = "gap", className = "" }: Props) {
	return (
		<div
			className={
				"flex justify-between font-normal items-center text-[10px] leading-[101%] w-full  primary-font" +
				(separator === "gap" ? "gap-x-4" : "") +
				" " +
				className
			}
		>
			<span>{left}</span>
			{separator === "dot" ? <span className="mx-2 opacity-60">·</span> : null}
			<span>{right}</span>
		</div>
	)
}