import type { DeveloperCardProps } from '@/entities/developer/types'

export const mockDevelopers: DeveloperCardProps[] = [
	{
		id: '1',
		image: '/images/developers/example.png',
		title: 'Группа ПИК',
		rating: 4.8,
		metaLeft: '18 лет на рынке',
		metaRight: '124 ЖК',
		tag: 'Лидер продаж',
		isFavorite: false,
	},
	{
		id: '2',
		image: '/images/developers/example.png',
		title: 'West Garden',
		rating: 4.6,
		metaLeft: '8 лет на рынке',
		metaRight: '54 ЖК',
		tag: 'Премиум',
		isFavorite: true,
	}
]