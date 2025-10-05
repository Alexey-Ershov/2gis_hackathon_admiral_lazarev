import { ReactNode } from "react";

/** Чистый layout без шапок/футеров — чтобы iFrame выглядел как карточка */
export default function WidgetLayout({children}: { children: ReactNode }) {
	return (
		<div className="min-h-screen bg-white text-black  flex justify-center py-[10px]">
			<div className="w-full">{ children }</div>
		</div>
	);
}