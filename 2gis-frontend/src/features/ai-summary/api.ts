
import { api } from '@shared/api/client'

export interface AISummaryResponse {
  summary: string
  reliabilityIndex?: number
}

export async function requestAISummary(p: {entityType: 'developer'|'complex', entityId: string}): Promise<AISummaryResponse> {
  return api.post('ai/summary', { json: p }).json<AISummaryResponse>()
}
