
import { createEffect, createEvent, createStore, sample } from 'effector'
import { requestAISummary } from './api'
import type { AISummaryResponse } from './api'

export const summaryRequested = createEvent<{entityType: 'developer'|'complex', entityId: string}>()

export const fetchAISummaryFx = createEffect(async (p: {entityType:'developer'|'complex', entityId: string}) => {
  return requestAISummary(p)
})

export const $summary = createStore<AISummaryResponse | null>(null)
  .on(fetchAISummaryFx.doneData, (_, data) => data)
export const $summaryPending = fetchAISummaryFx.pending

sample({ clock: summaryRequested, target: fetchAISummaryFx })
