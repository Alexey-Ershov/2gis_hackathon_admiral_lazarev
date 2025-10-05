import { gradients } from '@shared/theme/gradients';
import { SearchBar } from '@/features/search/SearchBar';
import { HeroHeader } from '@/widgets/Hero/HeroHeader';
import { RatingBadge } from "@shared/ui/RatingBadge";
import { TagBadge } from "@shared/ui/TagBadge";

export function Hero() {
	return (
		<section
			style={{
				backgroundImage: "url('/bg.svg')",
				backgroundRepeat: "no-repeat",
				backgroundSize: "cover",
				backgroundPosition: "center",
				width: "100%",
			}}
			className={ [

				// общий градиент из shared
				'flex flex-col items-center justify-center px-[20px] py-[32px] rounded-b-[50px]',
			].join(' ') }
		>
			<HeroHeader/>

			<div className="flex flex-col mt-[36px] w-full gap-[16px]">
				{/* Заголовок — переносы для мобилки и десктопа */ }
				<div className="
          font-semibold  leading-[110%]
          text-[28px] text-white primary-font flex-col
          ">
					<p className={"mb-[4px]"}>Проверьте репутацию<br/> застройщика</p>
				<p className="bg-white text-black px-[12px] py-[4px] rounded-[10px] primary-font w-fit font-semibold  leading-[110%]
          text-[28px]">за 2 минуты</p></div>

				<p className=" text-white/90 text-[14px] primary-font font-normal leading-[110%]">
					Все отзывы в одном месте.<br/>AI-анализ надежности
				</p>

				<div className="w-full">
					<SearchBar/>
				</div>
			</div>
		</section>
	);
}