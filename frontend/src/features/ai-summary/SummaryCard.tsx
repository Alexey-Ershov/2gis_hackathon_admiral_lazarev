import React, { useEffect } from "react";
import { DevelopersCarousel } from "@widgets/developers/Carousel";
import { useUnit } from "effector-react";
import { $popular, popularRequested } from "@entities/developer/model";

// Unified mockup-friendly props based on:
// title / image / heading1 / listpositives / markedlist / info(headings+description) / developer name / other projects list

type Props = {
	title: string;
	image: string;
	heading1: string; // e.g. "С 2018, 13 свободных квартир"
	listPositives: string[]; // badges that people praise
	markedList?: string[]; // badges that people just "отмечают"
	info: { heading: string; description: string }[]; // AI summary blocks
	developer: string; // developer name
	otherProjects?: { title: string; image: string; tags?: string[]; rating?: number }[]; // developer projects
};


export type InfoBlock = {
	heading: string;
	description: string;
};

export type DeveloperItem = {
	id?: number;
	title: string;
	image: string;
	heading1: string;
	listPositives: string[];
	markedList: string[];
	info: InfoBlock[];
	developer: string;
};

export default function SummaryCard({
	                                    data
                                    }: { data: DeveloperItem | undefined }) {

	const popular = useUnit($popular);

	useEffect(() => {
		popularRequested();
	}, []);

	console.log(data)

	return (
		<div className="w-full px-[10px] pb-0 text-[15px] text-gray-900">
			{/* Cover */ }
			{
				data !== undefined ? [<div className="relative rounded-[10px] overflow-hidden">
						<img src={ data.image } alt={ data.title } className="w-full h-48 object-cover"/>
						{/* затемнение */ }
						<div className="absolute inset-0 bg-black/20"/>
						<div className="primary-font absolute bottom-[55px] left-3 text-white text-[14px] font-medium">
							Жилой комплекс
						</div>
						<div
							className="primary-font absolute bottom-[0px] left-[15px] text-[42px] font-semibold text-white drop-shadow-lg">
							{ data.title }
						</div>
					</div>,

						<div className="mt-[20px] text-gray-800 flex-col gap-[20px]">
							{/* Heading line under title */ }
							<div className="text-[22px] font-normal primary-font ">{ data.heading1 }</div>

							{/* Positives */ }
							{ data.listPositives?.length ? (
								<>
									<h3 className="mt-3 text-[16px] font-semibold primary-font ">Люди ценят/хвалят</h3>
									<div className="flex flex-wrap gap-2 mt-2">
										{ data.listPositives.map((tag) => (
											<span
												key={ tag }
												className="bg-gray-200 text-gray-800 rounded-xl px-3 py-1 text-[14px] primary-font"
											>
                    { tag }
                  </span>
										)) }
									</div>
								</>
							) : null }

							{/* Marked issues/features */ }
							{ data.markedList?.length ? (
								<>
									<h3 className="mt-[20px] text-[16px] font-semibold primary-font">Люди отмечают</h3>
									<div className="flex flex-wrap gap-2 mt-2">
										{ data.markedList.map((tag) => (
											<span
												key={ tag }
												className="bg-gray-200 text-gray-800 rounded-xl px-3 py-1 text-[14px] primary-font"
											>
                    { tag }
                  </span>
										)) }
									</div>
								</>
							) : null }

							{ data.info?.length ? (
								<>
									<h3 className="mt-[20px] text-[16px] font-semibold primary-font">Что говорят жители? AI‑сводка.</h3>
									<ul className="list-none space-y-2 mt-2">
										{ data.info.map((s) => (
											<li key={ s.heading }>
									<span
										className="text-[#308414] font-semibold text-[14px] ml-[2px] indent-[-0.4px]"> • { "  " + s.heading }</span>
												<br/> { s.description }
											</li>
										)) }
									</ul>
								</>
							) : null }
							<div className="mt-6 text-[22px]">Застройщик { data.developer }</div>
							<DevelopersCarousel heading={ "Другие проекты застройщика" } className={ "px-0px" } items={ popular }
							                    onOpenAll={ () => {
							                    } }/>
						</div>]
					: <></> }
		</div>
	);
}