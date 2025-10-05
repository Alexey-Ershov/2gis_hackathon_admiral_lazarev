export type DeveloperCardProps = {
	id: string
	image: string
	title: string
	rating?: number
	metaLeft: string               // "8 лет на рынке"
	metaRight: string              // "54 жк"
	tag?: string
	isFavorite: boolean
	onOpen?: (id: string) => void
	onToggleFavorite?: (id: string, next: boolean) => void
}
