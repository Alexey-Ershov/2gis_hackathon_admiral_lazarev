import { useRef } from 'react'
import { useNavigate } from 'react-router-dom'
import { SearchIcon } from "@shared/assets/icons";
import { IconButton } from "@shared/assets/IconButton";

export function SearchBar() {
	const inputRef = useRef<HTMLInputElement>(null)
	const nav = useNavigate()

	const handleSearch = () => {
		const q = inputRef.current?.value?.trim()
		if (q) nav(`/search?q=${ encodeURIComponent(q) }`)
	}

	return (
		<div
			className="
				flex flex-row items-center w-full
				h-[38px]
				border border-[#D2D2D2]
				rounded-full px-[20px] py-[10px]
				bg-[#ffffff]
				cursor-pointer
			"
		>
			<input
				ref={ inputRef }
				type="text"
				placeholder="Название застройщика или ЖК"
				className="flex bg-white outline-none w-full
					primary-font font-semibold text-[12px] leading-[122.3%]
					text-[#858585] placeholder:text-[#858585]
				"
				onKeyDown={ (e) => e.key === 'Enter' && handleSearch() }
			/>
			<IconButton
				onClick={ handleSearch }
				className="transition"
				aria-label="Поиск"
			>
				<SearchIcon/>
			</IconButton>
		</div>
	)
}
