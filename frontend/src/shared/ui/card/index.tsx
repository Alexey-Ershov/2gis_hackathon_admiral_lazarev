// src/shared/ui/card/index.ts
export { Card } from "./Card"
export { CardCover } from "./CardCover"
export { CardFavButton } from "./CardFavButton"
export { CardRating } from "./CardRating"
export { CardTag } from "./CardTag"
export { CardTitle } from "./CardTitle"
export { CardMetaRow } from "./CardMetaRow"


// Card: только визуал
type CardProps = {
	className?: string
	onClick?: () => void           // навигация по клику на карточку (не обяз.)
}

// Cover
type CardCoverProps = {
	src: string
	alt?: string
	height?: number
	// слот для пинов (rating/fav/tag) — children
}

// FavButton (чистая кнопка)
type CardFavButtonProps = {
	isActive?: boolean             // отрисовка состояния (по желанию)
	onClick?: () => void           // поднимем наверх
}