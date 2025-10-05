import { api } from '@shared/api/client'
import { DeveloperCardProps } from "@entities/developer/types";

// export async function fetchDeveloper(id: string): Promise<DeveloperCardProps> {
// 	return api.get(`developers/${ id }`).json<DeveloperCardProps>()
// }
//
// export async function fetchPopular(): Promise<DeveloperCardProps[]> {
// 	return api.get('developers', {searchParams: {popular: '1'}}).json<DeveloperCardProps[]>()
// }


import { mockDevelopers } from './mocks'

export async function fetchDeveloper(id: string) {
	await new Promise((r) => setTimeout(r, 300))
	return mockDevelopers.find((d) => d.id === id)!
}

export async function fetchPopular() {
	await new Promise((r) => setTimeout(r, 500))
	return mockDevelopers
}