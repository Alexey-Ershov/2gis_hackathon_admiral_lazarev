import { IconButton } from '@shared/assets/IconButton';
import { HeartIcon, MenuIcon } from '@shared/assets/icons';

export function HeroHeader() {
	return (
		<div className="flex flex-row items-center justify-between w-full">
			<div className="flex flex-row text-white text-[22px] font-bold text-lg">Проверь<div className={"text-accent"}>.</div>дом</div>
			<div className="flex items-center gap-2 md:gap-3">
				<IconButton aria-label="Избранное"><HeartIcon/></IconButton>
				<IconButton aria-label="Меню"><MenuIcon/></IconButton>
			</div>
		</div>
	);
}