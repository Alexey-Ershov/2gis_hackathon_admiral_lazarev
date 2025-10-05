import { useEffect } from 'react';
import { useUnit } from 'effector-react';
import { popularRequested, $popular } from '@entities/developer/model';
import { Hero } from '@/widgets/Hero/Hero';
import { DevelopersCarousel } from "@widgets/developers/Carousel";

export function LandingPage() {
	const popular = useUnit($popular);

	useEffect(() => {
		popularRequested();
	}, []);

	return (
		<div className="gap-[32px]">
			<Hero/>

			<DevelopersCarousel heading={"Популярные застройщики"} className={"px-[20px]"} items={ popular } onOpenAll={ () => {
			} }/>

			<DevelopersCarousel heading={"ЖК, которые часто выбирают"} className={"px-[20px]"} items={ popular } onOpenAll={ () => {
			} }/>
		</div>
	);
}