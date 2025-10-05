
import { createEffect, createStore, createEvent, sample } from 'effector'
import type { Developer } from '@shared/types'
import { fetchDeveloper, fetchPopular } from '@/entities/developer/api'
import { DeveloperCardProps } from "@entities/developer/types";

export const developerRequested = createEvent<{id: string}>()
export const popularRequested = createEvent<void>()

export const getDeveloperFx = createEffect(async ({id}: {id:string}) => fetchDeveloper(id))
export const getPopularFx = createEffect(async () => fetchPopular())

export const $developer = createStore<DeveloperCardProps | null>(null)
  .on(getDeveloperFx.doneData, (_, d) => d)
export const $popular = createStore<DeveloperCardProps[]>([])
  .on(getPopularFx.doneData, (_, list) => list)

sample({ clock: developerRequested, target: getDeveloperFx })
sample({ clock: popularRequested, target: getPopularFx })
