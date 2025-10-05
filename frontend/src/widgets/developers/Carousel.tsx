// widgets/developers/Carousel.tsx
import { DeveloperCard } from "@entities/developer/ui/DeveloperCard";
import { useNavigate } from "react-router-dom";
import { DeveloperCardProps } from "@entities/developer/types";

export function DevelopersCarousel({heading, className, items, onOpenAll}: {
	heading: string;
	className?: string,
	items: DeveloperCardProps[],
	onOpenAll: () => void
}) {

	const navigate = useNavigate();

	return (
		<section className={ "flex flex-col mt-[32px] gap-[20px] " + className }>
			<header className="flex items-center justify-between primary-font">
				<p className="text-[18px] font-semibold leading-0 primary-font">{heading}</p>
				<button onClick={ onOpenAll } className="text-[14px] primary-font text-black/60">Все →</button>
			</header>

			<div className="flex gap-[10px] overflow-x-auto no-scrollbar justify-between">
				{ items.map(dev => (
					<DeveloperCard
						key={ dev.id }
						id={ dev.id }
						image={ dev.image }
						title={ dev.title }
						rating={ dev.rating }
						tag={ dev.tag }
						metaLeft={ dev.metaLeft }
						metaRight={ dev.metaRight }
						isFavorite={ dev.isFavorite }
						// поведение передаёт страница/виджет:
						onOpen={ () => navigate(`/developers/${ dev.id }`) }
						onToggleFavorite={ dev.onToggleFavorite }
					/>
				)) }
			</div>
		</section>
	)
}